package racingcarGame;

import racingcarGame.domain.RacingGame;
import racingcarGame.exception.GameCancelFlagException;
import racingcarGame.exception.InputEmptyException;
import racingcarGame.exception.InputNullException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RacingGameTest {
    @Test
    @DisplayName("자동차의 이름이 null 값일 경우")
    void input_null_car_name() {
        assertThatThrownBy(() -> new RacingGame(null, 5)).isInstanceOf(InputNullException.class);
    }

    @Test
    @DisplayName("자동차의 이름이 비어있을 경우")
    void input_empty_car_name() {
        assertThatThrownBy(() -> new RacingGame("", 5)).isInstanceOf(InputEmptyException.class);
    }

    @Test
    @DisplayName("혼자 참가하면 자동 우승")
    void input_alone_return_winner() {
        assertThat(new RacingGame("chan", 5).play()).isEqualTo("chan");
    }

    @Test
    @DisplayName("자동차 이름을 (,)로 구분하여 저장")
    void car_name_save() {
        RacingGame racingGame = new RacingGame("chan,bin,dong,bang,eun", 5);
        assertThat(racingGame.getCars().getFirstName()).isEqualTo("chan");
    }

    @Test
    @DisplayName("전진 시도 횟수가 0일 경우")
    void move_number_0() {
        assertThatThrownBy(() -> new RacingGame("chan,bin,dong,bang,eun", 0)).isInstanceOf(GameCancelFlagException.class);
    }
}
