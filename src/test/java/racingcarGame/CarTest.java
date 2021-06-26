package racingcarGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcarGame.domain.Car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car("chan");
    }

    @Test
    @DisplayName("잘 저장 되는지")
    void car_name_save() {
        assertThat(car.getName().getName()).isEqualTo("chan");
        assertThat(car.getPosition().getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("이동")
    void car_move() {
        //when
        Car movedCar = car.move(() -> true);

        // then
        assertThat(movedCar.getPosition().getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("정지")
    void car_stop() {
        //when
        Car movedCar = car.move(() -> false);

        // then
        assertThat(movedCar.getPosition().getPosition()).isEqualTo(0);
    }
}
