package racingcarGame.exception;

public class InputEmptyException extends RuntimeException {
    public InputEmptyException() {
        super("입력 값 없음");
    }
}
