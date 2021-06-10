package racingcarGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcarGame.domain.Equipment;
import racingcarGame.exception.NameOverflowException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class EquipmentTest {
    @Test
    @DisplayName("이름이 5자리가 초과되는 경우")
    void car_name_over() {
        assertThatThrownBy(() -> new Equipment("leeheechan"))
                .isInstanceOf(NameOverflowException.class);
    }
}
