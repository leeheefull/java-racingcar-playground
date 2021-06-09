package racingcarGame.domain;

import racingcarGame.exception.GameCancelFlagException;
import racingcarGame.exception.InputEmptyException;
import racingcarGame.exception.InputNullException;
import racingcarGame.utils.Constants;

public class RacingGame {
    private final Cars cars;
    private final int moveCnt;

    public RacingGame(String input, int turnNumber) {
        validate(input, turnNumber);
        this.cars = new Cars(splitInput(input));
        this.moveCnt = turnNumber;
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

    private void validate(String input, int turnNumber) {
        if (input == null) {
            throw new InputNullException();
        }
        if (input.equals("")) {
            throw new InputEmptyException();
        }
        if (turnNumber == 0) {
            throw new GameCancelFlagException();
        }
    }
}
