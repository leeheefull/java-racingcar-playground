package StringAddCalculator.model;

import StringAddCalculator.utils.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputString {
    private final List<Number> numbers = new ArrayList<>();
    private final List<Separator> separators = new ArrayList<>();

    public InputString(String input) {
        if (isEmpty(input)) {
            return;
        }
        addSeparator(",");
        addSeparator(":");
        input = findNewSeparator(input);

        for (String value : input.split(getSeparators())) {
            this.numbers.add(new Number(Integer.parseInt(value)));
        }
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    public String getSeparators() {
        return separators.stream()
                .map(Separator::getSeparator)
                .collect(Collectors.joining("|"));
    }

    public boolean isEmpty() {
        return this.numbers.isEmpty();
    }

    private boolean isEmpty(String input) {
        return input == null || input.equals("");
    }

    private String findNewSeparator(String input) {
        Matcher matcher = Pattern.compile(Constants.NEW_SEPARATOR).matcher(input);
        if (matcher.find()) {
            addSeparator(matcher.group(Constants.BEFORE));
            input = matcher.group(Constants.AFTER);
        }
        return input;
    }

    private void addSeparator(String separator) {
        separators.add(new Separator(separator));
    }
}
