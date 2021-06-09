package stringAddCalculator.domain;

import stringAddCalculator.exception.InputNotSeparatorException;
import stringAddCalculator.utils.Constants;

public class Separator {
    private final String separator;

    public Separator(String separator) {
        validate(separator);
        this.separator = separator;
    }

    public String getSeparator() {
        return separator;
    }

    private void validate(String separator) {
        if (!isSeparator(separator)) {
            throw new InputNotSeparatorException();
        }
    }

    private boolean isSeparator(String separator) {
        return separator.matches(Constants.NO_SEPARATOR_REGEX);
    }
}
