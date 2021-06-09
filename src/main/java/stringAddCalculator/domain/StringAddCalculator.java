package stringAddCalculator.domain;

import stringAddCalculator.utils.Constants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private final Numbers numbers;

    public StringAddCalculator(String input) {
        if (isEmpty(input)) {
            this.numbers = new Numbers();
            return;
        }
        Separators separators = new Separators();
        Matcher matcher = Pattern.compile(Constants.NEW_SEPARATOR).matcher(input);
        if (matcher.find()) {
            separators.addStringSeparator(matcher.group(Constants.BEFORE));
            input = matcher.group(Constants.AFTER);
        }
        this.numbers = new Numbers(input.split(separators.getRegex()));
    }

    public int calculate() {
        if (this.numbers.getNumbers().isEmpty()) {
            return 0;
        }
        return this.numbers.addNumbers();
    }

    private boolean isEmpty(String input) {
        return input == null || input.equals("");
    }
}