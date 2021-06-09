package RacingcarGame.exception;

public class CarNameOverflowException extends RuntimeException {
    @Override
    public String getMessage() {
        return "자동차 이름 자리수 초과";
    }
}
