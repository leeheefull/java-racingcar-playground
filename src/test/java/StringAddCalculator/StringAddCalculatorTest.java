package StringAddCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
}
