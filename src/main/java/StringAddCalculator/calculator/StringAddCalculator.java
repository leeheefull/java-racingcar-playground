package StringAddCalculator.calculator;

import StringAddCalculator.model.InputString;
import StringAddCalculator.model.Number;

public class StringAddCalculator {
    private final InputString inputString;

    public StringAddCalculator(String input) {
        this.inputString = new InputString(input);
    }

    public int calculate() {
        if (inputString.isEmpty()) {
            return 0;
        }
        return this.inputString
                .getNumbers()
                .stream()
                .mapToInt(Number::getNumber)
                .reduce(Integer::sum)
                .getAsInt();
    }
}
