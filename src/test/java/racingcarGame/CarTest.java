package racingcarGame;

import racingcarGame.domain.Car;
import racingcarGame.exception.CarNameOverflowException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CarTest {
    @Test
    @DisplayName("자동차의 이름이 5자리가 초과되는 경우")
    void car_name_over() {
        assertThatThrownBy(() -> new Car("leeheechan")).isInstanceOf(CarNameOverflowException.class);
    }
}
