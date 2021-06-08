package StringAddCalculator.calculator;

import StringAddCalculator.model.Number;
import StringAddCalculator.model.Numbers;
import StringAddCalculator.model.Separators;
import StringAddCalculator.utils.Constants;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private final Numbers numbers = new Numbers();
    private final Separators separators = new Separators();

    public StringAddCalculator(String input) {
        if (isEmpty(input)) {
            return;
        }
        input = findNewSeparator(input);

        for (String value : input.split(separators.getStringSeparators())) {
            this.numbers.addStringNumber(value);
        }
    }

    public int calculate() {
        if (numbers.isEmpty()) {
            return 0;
        }
        return this.numbers
                .getNumbers()
                .stream()
                .mapToInt(Number::getNumber)
                .reduce(Integer::sum)
                .getAsInt();
    }

    private boolean isEmpty(String input) {
        return input == null || input.equals("");
    }

    private String findNewSeparator(String input) {
        Matcher matcher = Pattern.compile(Constants.NEW_SEPARATOR).matcher(input);
        if (matcher.find()) {
            separators.addStringSeparator(matcher.group(Constants.BEFORE));
            input = matcher.group(Constants.AFTER);
        }
        return input;
    }
}