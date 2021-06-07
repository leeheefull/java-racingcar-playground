package StringAddCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorNo {
    private final List<Integer> values;

    public CalculatorNo(String input) {
        this.values = new ArrayList<>();
        if (isEmpty(input)) {
            return;
        }

        String regex = "[,:]";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            regex += "|" + m.group(1);
            input = m.group(2);
        }

        String[] values = input.split(regex);
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
