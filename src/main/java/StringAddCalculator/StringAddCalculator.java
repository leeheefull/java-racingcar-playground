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
        return this.numbers
                .getValues()
                .stream()
                .reduce(Integer::sum)
                .get();
    }
}
