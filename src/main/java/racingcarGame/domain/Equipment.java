package racingcarGame.domain;

import racingcarGame.exception.NameOverflowException;

public class Equipment {
    public final int NAME_MAX_SIZE = 5;

    private final String name;

    public Equipment(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void validate(String input) {
        if (isNameSizeOver(input)) {
            throw new NameOverflowException();
        }
    }

    private boolean isNameSizeOver(String input) {
        return NAME_MAX_SIZE < input.length();
    }
}
