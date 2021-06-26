package racingcarGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcarGame.domain.Position;
import racingcarGame.exception.InputPositionException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PositionTest {
    @Test
    @DisplayName("0보다 작은 위치 값")
    void car_position_error() {
        assertThatThrownBy(() -> new Position(-1))
                .isInstanceOf(InputPositionException.class);
    }
}
