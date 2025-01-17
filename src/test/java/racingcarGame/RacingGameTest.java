package racingcarGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcarGame.domain.RacingGame;
import racingcarGame.exception.GameCancelFlagException;
import racingcarGame.exception.InputEmptyException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RacingGameTest {
    @Test
    @DisplayName("자동차의 이름이 null 값일 경우")
    void input_null_car_name() {
        assertThatThrownBy(() -> new RacingGame(null, 5))
                .isInstanceOf(InputEmptyException.class);
    }

    @Test
    @DisplayName("자동차의 이름이 비어있을 경우")
    void input_empty_car_name() {
        assertThatThrownBy(() -> new RacingGame("", 5))
                .isInstanceOf(InputEmptyException.class);
    }

    @Test
    @DisplayName("전진 시도 횟수가 0일 경우")
    void move_number_0() {
        assertThatThrownBy(() -> new RacingGame("chan,bin,dong,bang,eun", 0))
                .isInstanceOf(GameCancelFlagException.class);
    }

    @Test
    @DisplayName("게임 플레이 성공")
    void play() {
        // given
        RacingGame racingGame = new RacingGame("chan,bin", 3);

        // when
        racingGame.play();

        // then
        assertThat(racingGame.getCars().getWinner().size() > 0).isTrue();
    }
}