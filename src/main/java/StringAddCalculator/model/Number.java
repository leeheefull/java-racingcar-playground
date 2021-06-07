package StringAddCalculator.model;

import StringAddCalculator.exception.InputNotNumberException;
import StringAddCalculator.utils.Constants;

public class Number {
    private final int number;

    public Number(int number) {
        validate(number);
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    private void validate(int number) {
        if (!isNumber(number)) {
            throw new InputNotNumberException();
        }
    }

    private boolean isNumber(int number) {
        return Constants.MIN_NUMBER <= number && number <= Constants.MAX_NUMBER;
    }
}
