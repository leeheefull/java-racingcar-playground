package RacingcarGame.domain;

import RacingcarGame.exception.InputEmptyException;
import RacingcarGame.exception.InputNullException;

public class RacingGame {
    public RacingGame(String input) {
        if (input == null) {
            throw new InputNullException();
        }
        if (input.equals("")) {
            throw new InputEmptyException();
        }
    }
}
