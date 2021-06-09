package racingcarGame.domain;

import racingcarGame.exception.InputEmptyException;
import racingcarGame.exception.InputNullException;
import racingcarGame.utils.Constants;

public class RacingGame {
    private final Cars cars;

    public RacingGame(String input) {
        validate(input);
        this.cars = new Cars(splitInput(input));
    }

    public Cars getCars() {
        return cars;
    }

    public String play() {
        if (cars.isAlone()) {
            return cars.getFirstName();
        }
        return null;
    }

    private String[] splitInput(String input) {
        return input.split(Constants.SEPARATOR);
    }

    private void validate(String input) {
        if (input == null) {
            throw new InputNullException();
        }
        if (input.equals("")) {
            throw new InputEmptyException();
        }
    }
}
