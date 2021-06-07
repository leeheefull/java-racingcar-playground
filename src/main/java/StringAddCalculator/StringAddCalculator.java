package StringAddCalculator;

public class StringAddCalculator {
    private CalculatorNo numbers;

    public StringAddCalculator(String input) {
        this.numbers = new CalculatorNo(input);
    }

    public int calculate() {
        if (numbers.getValues().isEmpty()) {
            return 0;
        }
        return 1;
    }
}
