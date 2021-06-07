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
            validate(value);
            this.values.add(Integer.parseInt(value));
        }
    }

    public List<Integer> getValues() {
        return values;
    }

    private void validate(String value) {
        if (!isNumber(value)) {
            throw new InputNotNumberException();
        }
        if (!isKnownSeparator(value)) {
            throw new UnknownSeparatorException();
        }
    }

    private boolean isNumber(String value) {
        return '0' <= value.charAt(0) && value.charAt(0) <= '9';
    }

    private boolean isEmpty(String input) {
        return input == null || input.equals("");
    }

    private boolean isKnownSeparator(String value) {
        return value.length() == 1;
    }

    public boolean isEmpty() {
        return this.values.isEmpty();
    }
}
