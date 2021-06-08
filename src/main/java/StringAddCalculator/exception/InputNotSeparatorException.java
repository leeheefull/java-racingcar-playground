package StringAddCalculator.exception;

public class InputNotSeparatorException extends RuntimeException {
    @Override
    public String getMessage() {
        return "구분자가 아닌 값을 입력했습니다.";
    }
}
