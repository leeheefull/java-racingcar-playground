package racingcarGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcarGame.domain.Name;
import racingcarGame.exception.NameOverflowException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class NameTest {
    @Test
    @DisplayName("이름이 5자리가 초과되는 경우")
    void car_name_over() {
        assertThatThrownBy(() -> new Name("leeheechan"))
                .isInstanceOf(NameOverflowException.class);
    }
}
