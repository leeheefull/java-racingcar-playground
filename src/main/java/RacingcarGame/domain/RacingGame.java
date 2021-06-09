package RacingcarGame.domain;

import RacingcarGame.exception.InputEmptyException;
import RacingcarGame.exception.InputNullException;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final Cars cars;

    public RacingGame(String input) {
        if (input == null) {
            throw new InputNullException();
        }
        if (input.equals("")) {
            throw new InputEmptyException();
        }
        this.cars = new Cars(input);
    }

    public String play() {
        if (cars.isAlone()) {
            return cars.getCars().get(0).getName();
        }
        return null;
    }
}
