package racingcarGame.exception;

public class CarNameOverflowException extends RuntimeException {
    public CarNameOverflowException() {
        super("자동차 이름 자리수 초과");
    }
}
