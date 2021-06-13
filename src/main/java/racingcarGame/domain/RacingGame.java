package racingcarGame.domain;

import racingcarGame.exception.GameCancelFlagException;
import racingcarGame.exception.InputEmptyException;

public class RacingGame {
    private final Cars cars;
    private final int moveCnt;

    public RacingGame(String input, int moveCnt) {
        validate(input, moveCnt);
        this.cars = new Cars(input);
        this.moveCnt = moveCnt;
    }

    public Cars getCars() {
        return cars;
    }

    public String play() {
        StringBuilder output = new StringBuilder();
        int cnt = this.moveCnt;
        while (cnt-- > 0) {
            this.cars.moveOrStop();
            output.append(this.cars);
        }
        return output.toString();
    }

    private void validate(String input, int moveCnt) {
        if (isEmpty(input)) {
            throw new InputEmptyException();
        }
        if (moveCnt == 0) {
            throw new GameCancelFlagException();
        }
    }

    private boolean isEmpty(String input) {
        return input == null || input.equals("");
    }
}
