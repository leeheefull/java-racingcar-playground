package StringAddCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
}
