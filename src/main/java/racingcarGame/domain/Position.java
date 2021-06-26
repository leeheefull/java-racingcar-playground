package racingcarGame.domain;

import racingcarGame.exception.InputPositionException;

public class Position {
    private final int position;

    public Position(int position) {
        validate(position);
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public Position advance() {
        return new Position(this.position + 1);
    }

    private void validate(int position) {
        if (position < 0) {
            throw new InputPositionException();
        }
    }
}
