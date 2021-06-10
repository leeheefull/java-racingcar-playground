package racingcarGame;

import org.junit.jupiter.api.BeforeEach;
import racingcarGame.domain.Car;
import racingcarGame.domain.Vehicle;
import racingcarGame.exception.NameOverflowException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class VehicleTest {
    private Vehicle vehicle;

    @BeforeEach
    void setUp() {
        this.vehicle = new Vehicle("chan", 0);
    }

    @Test
    @DisplayName("잘 저장 되는지")
    void car_name_save() {
        assertThat(vehicle.getName()).isEqualTo("chan");
        assertThat(vehicle.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("잘 움직이는지")
    void car_move() {
        //when
        vehicle.move();

        // then
        assertThat(vehicle.getPosition()).isEqualTo(1);
    }
}
