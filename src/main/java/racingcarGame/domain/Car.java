package racingcarGame.domain;

import racingcarGame.exception.CarNameOverflowException;
import racingcarGame.utils.Constants;

public class Car {
    private final String name;

    public Car(String input) {
        validate(input);
        this.name = input;
    }

    public String getName() {
        return name;
    }

    private void validate(String input) {
        if (isNameSizeOver(input)) {
            throw new CarNameOverflowException();
        }
    }

    private boolean isNameSizeOver(String input) {
        return Constants.CAR_NAME_MAX_SIZE < input.length();
    }
}
