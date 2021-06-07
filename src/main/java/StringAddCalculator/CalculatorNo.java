package StringAddCalculator;

import java.util.ArrayList;
import java.util.List;

public class CalculatorNo {
    private final List<Integer> values;

    public CalculatorNo(String input) {
        this.values = new ArrayList<>();
        if (isEmpty(input)) {
            return;
        }
        String[] values = input.split("[,:]");
        for (String value : values) {
            this.values.add(Integer.parseInt(value));
        }
    }

    public List<Integer> getValues() {
        return values;
    }

    private boolean isEmpty(String input) {
        return input == null || input.equals("");
    }

    public boolean isEmpty() {
        return this.values.isEmpty();
    }
}
