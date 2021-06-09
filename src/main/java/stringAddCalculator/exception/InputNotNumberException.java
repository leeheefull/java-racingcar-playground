package stringAddCalculator.exception;

public class InputNotNumberException extends RuntimeException {
    @Override
    public String getMessage() {
        return "숫자가 아닌 값을 입력했습니다.";
    }
}
