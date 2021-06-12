package stringAddCalculator.domain;

import stringAddCalculator.utils.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Separators {
    private final List<Separator> separators;

    public Separators() {
        this.separators = new ArrayList<>();
        this.separators.addAll(Arrays.asList(new Separator(Constants.BASIC_REGEX_1), new Separator(Constants.BASIC_REGEX_2)));
    }

    public String getRegex() {
        return this.separators
                .stream()
                .map(Separator::getSeparator)
                .collect(Collectors.joining(Constants.DELIMITER));
    }

    public void addStringSeparator(String separator) {
        this.separators.add(new Separator(separator));
    }
}
