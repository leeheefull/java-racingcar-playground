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
        if (isSizeOne(values)) {
            this.values.add(Integer.parseInt(values[0]));
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

    private boolean isSizeOne(String[] values) {
        return values.length == 1;
    }

    public boolean isSizeOne() {
        return this.values.size() == 1;
    }
}
