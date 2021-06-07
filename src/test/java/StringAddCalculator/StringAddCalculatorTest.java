package StringAddCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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
}
