package StringAddCalculator.model;

import StringAddCalculator.utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputString {
    private final List<Number> numbers;
    private final Separator separator;

    public InputString(String input) {
        this.numbers = new ArrayList<>();
        this.separator = new Separator();

        if (isEmpty(input)) {
            return;
        }
        input = applyNewSeparator(input);

        for (String value : input.split(separator.getSeparator())) {
            this.numbers.add(new Number(Integer.parseInt(value)));
        }
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    public boolean isEmpty() {
        return this.numbers.isEmpty();
    }

    private String applyNewSeparator(String input) {
        Matcher matcher = Pattern.compile(Constants.NEW_SEPARATOR).matcher(input);
        if (matcher.find()) {
            separator.add(matcher.group(Constants.BEFORE));
            input = matcher.group(Constants.AFTER);
        }
        return input;
    }

    private boolean isEmpty(String input) {
        return input == null || input.equals("");
    }
}
