package racingcarGame.domain;

import racingcarGame.exception.CarNameOverflowException;
import racingcarGame.utils.Constants;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this(name, 0);
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

    public void move() {
        this.position++;
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
