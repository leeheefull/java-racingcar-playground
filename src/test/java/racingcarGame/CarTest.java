package racingcarGame;

import org.junit.jupiter.api.BeforeEach;
import racingcarGame.domain.Car;
import racingcarGame.exception.CarNameOverflowException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        this.car = new Car("chan");
    }

    @Test
    @DisplayName("자동차의 이름이 5자리가 초과되는 경우")
    void car_name_over() {
        assertThatThrownBy(() -> new Car("leeheechan"))
                .isInstanceOf(CarNameOverflowException.class);
    }

    @Test
    @DisplayName("자동차가 잘 저장 되는지")
    void car_name_save() {
        assertThat(car.getName()).isEqualTo("chan");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차가 잘 움직이는지")
    void car_move() {
        //when
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }
}
