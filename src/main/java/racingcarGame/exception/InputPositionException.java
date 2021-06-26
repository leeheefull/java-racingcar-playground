package racingcarGame.exception;

import java.util.InputMismatchException;

public class InputPositionException extends InputMismatchException {
    public InputPositionException() {
        super("적용할 수 없는 위치 값입니다.");
    }
}
