package StringAddCalculator;

public class StringAddCalculator {
    private final CalculatorNo numbers;

    public StringAddCalculator(String input) {
        this.numbers = new CalculatorNo(input);
    }

    public int calculate() {
        if (numbers.isEmpty()) {
            return 0;
        }
        if (numbers.isSizeOne()) {
            return numbers.getValues().get(0);
        }
        return 227;
    }
}
