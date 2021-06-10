package racingcarGame.exception;

public class NameOverflowException extends RuntimeException {
    public NameOverflowException() {
        super("자동차 이름 자리수 초과");
    }
}
