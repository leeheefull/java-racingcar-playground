package racingcarGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcarGame.domain.Car;
import racingcarGame.domain.RacingGame;
import racingcarGame.exception.GameCancelFlagException;
import racingcarGame.exception.InputEmptyException;
import racingcarGame.exception.InputNullException;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RacingGameTest {
    @Test
    @DisplayName("자동차의 이름이 null 값일 경우")
    void input_null_car_name() {
        assertThatThrownBy(() -> new RacingGame(null, 5))
                .isInstanceOf(InputNullException.class);
    }

    @Test
    @DisplayName("자동차의 이름이 비어있을 경우")
    void input_empty_car_name() {
        assertThatThrownBy(() -> new RacingGame("", 5))
                .isInstanceOf(InputEmptyException.class);
    }

    @Test
    @DisplayName("혼자 참가하면 자동 우승")
    void input_alone_return_winner() {
        assertThat(new RacingGame("chan", 5).getWinner().get(0).getName())
                .isEqualTo("chan");
    }

    @Test
    @DisplayName("자동차 이름을 (,)로 구분하여 저장")
    void car_name_save() {
        // given
        List<Car> actual = new RacingGame("chan,bin,dong,bang,eun", 5).getCars();
        List<String> expected = Arrays.asList("chan", "bin", "dong", "bang", "eun");

        // when, then
        for (int i = 0; i < actual.size(); i++) {
            assertThat(actual.get(i).getName()).isEqualTo(expected.get(i));
        }
    }

    @Test
    @DisplayName("전진 시도 횟수가 0일 경우")
    void move_number_0() {
        assertThatThrownBy(() -> new RacingGame("chan,bin,dong,bang,eun", 0))
                .isInstanceOf(GameCancelFlagException.class);
    }
}