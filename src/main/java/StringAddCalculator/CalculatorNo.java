package StringAddCalculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorNo {
    private List<Integer> values;

    public CalculatorNo(String input) {
        if (isEmpty(input)) {
            this.values = new ArrayList<>();
        }
    }

    public List<Integer> getValues() {
        return values;
    }

    private boolean isEmpty(String input) {
        return input == null || input.equals("");
    }
}
