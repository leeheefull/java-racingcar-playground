package StringAddCalculator.model;

import StringAddCalculator.exception.InputNotSeparatorException;

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
        return separator.charAt(0) < '1' || '9' < separator.charAt(0);
    }
}
