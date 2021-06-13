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
        assertThat(car.getName()).isEqualTo("chan");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("잘 움직이는지")
    void car_move() {
        //when
        Car movedCar = car.move();

        // then
        assertThat(movedCar.getPosition()).isEqualTo(1);
    }
}
