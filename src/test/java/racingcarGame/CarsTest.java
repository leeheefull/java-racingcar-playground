package racingcarGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcarGame.domain.Cars;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarsTest {
    @Test
    @DisplayName("혼자 참가하면 자동 우승")
    void input_alone_return_winner() {
        assertThat(new Cars("chan").getWinner().get(0).getName().getName())
                .isEqualTo("chan");
    }

    @Test
    @DisplayName("자동차 이름을 (,)로 구분하여 저장")
    void car_name_save() {
        // given
        Cars actual = new Cars("chan,bin,dong,bang,eun");
        List<String> expected = Arrays.asList("chan", "bin", "dong", "bang", "eun");

        // when, then
        for (int i = 0; i < actual.getCars().size(); i++) {
            assertThat(actual.getCars().get(i).getName().getName()).isEqualTo(expected.get(i));
        }
    }
}
