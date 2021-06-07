package StringAddCalculator.calculator;

import StringAddCalculator.exception.InputNotNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("NULL 값 또는 빈 문자열 입력시 0 반환")
    void input_null_return_0() {
        assertThat(new StringAddCalculator(null).calculate()).isEqualTo(0);
    }

    @Test
    @DisplayName("빈 문자열 입력시 0 반환")
    void input_empty_return_0() {
        assertThat(new StringAddCalculator("").calculate()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "1:", "1,"})
    @DisplayName("숫자 한 개 입력시 그대로 반환")
    void input_one_number(String input) {
        assertThat(new StringAddCalculator(input).calculate()).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,2=3",
            "3:4=7",
            "5,6:7=18",
            "1,2,3:4:5:6=21"
    }, delimiter = '=')
    @DisplayName("(, 또는 :)로 구분하여 숫자들의 합 계산")
    void calculate_success(String input, int expected) {
        assertThat(new StringAddCalculator(input).calculate()).isEqualTo(expected);
    }

    @Test
    @DisplayName("새로운 구분자를 추가하여 계산")
    void calculate_new_separator() {
        assertThat(new StringAddCalculator("//;\n1;2,3:4,5;6").calculate()).isEqualTo(21);
    }

    @Test
    @DisplayName("숫자와 구분자 이외의 값을 입력할 경우")
    void input_string_exception() {
        assertThatThrownBy(() -> new StringAddCalculator("-2,4")).isInstanceOf(InputNotNumberException.class);
    }

    @Test
    @DisplayName("지정되지 않은 구분자를 입력할 경우")
    void input_unknown_separator() {
        assertThatThrownBy(() -> new StringAddCalculator("2;3")).isInstanceOf(NumberFormatException.class);
    }
}
