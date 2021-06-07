package StringAddCalculator;

public class UnknownSeparatorException extends RuntimeException {
    @Override
    public String getMessage() {
        return "지정되지 않은 구분자를 입력했습니다.";
    }
}
