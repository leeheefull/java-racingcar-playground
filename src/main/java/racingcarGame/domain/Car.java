package racingcarGame.domain;

import racingcarGame.exception.CarNameOverflowException;
import racingcarGame.utils.Constants;

public class Car {
    private final String name;
    private final int position;

    public Car(String name) {
        validate(name);
        this.name = name;
        this.position = 0;
    }

    public Car(String input, int position) {
        validate(input);
        this.name = input;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public Car move() {
        return new Car(this.name, this.position + 1);
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
