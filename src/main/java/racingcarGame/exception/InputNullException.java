package racingcarGame.exception;

public class InputNullException extends NullPointerException {
    @Override
    public String getMessage() {
        return "입력 값 없음";
    }
}
