package RacingcarGame.exception;

public class InputEmptyException extends RuntimeException {
    @Override
    public String getMessage() {
        return "입력 값 없음";
    }
}
