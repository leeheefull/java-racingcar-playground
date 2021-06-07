package StringAddCalculator.model;

import StringAddCalculator.exception.InputNotNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class InputStringTest {
    @Test
    @DisplayName("옳은 입력 값")
    void Input_string() {
        InputString inputString = new InputString("1,2:3");

        for (int i = 0; i < inputString.getNumbers().size(); i++) {
            Number number = inputString.getNumbers().get(i);
            assertThat(number.getNumber()).isEqualTo(i + 1);
        }
    }

    @Test
    @DisplayName("숫자와 구분자 이외의 값을 입력할 경우")
    void input_string_exception() {
        assertThatThrownBy(() -> new InputString("-2,4")).isInstanceOf(InputNotNumberException.class);
    }

    @Test
    @DisplayName("지정되지 않은 구분자를 입력할 경우")
    void input_unknown_separator() {
        assertThatThrownBy(() -> new InputString("2;3")).isInstanceOf(NumberFormatException.class);
    }
}
