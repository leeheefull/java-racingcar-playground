package racingcarGame.domain;

import racingcarGame.exception.NameOverflowException;

public class Name {
    public static final int NAME_MAX_SIZE = 5;

    private final String name;

    public Name(String name) {
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

    @Override
    public String toString() {
        return name + "";
    }
}
