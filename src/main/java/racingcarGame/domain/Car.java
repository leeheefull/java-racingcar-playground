package racingcarGame.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car {
    private final Name name;
    private final Position position;

    public static final String MOVE_MARK = "-";

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int position) {
        this.name = new Name(name);
        this.position = new Position(position);
    }

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Name getName() {
        return this.name;
    }

    public Position getPosition() {
        return this.position;
    }

    public Car move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            return new Car(this.name, this.position.advance());
        }
        return new Car(this.name, this.position);
    }

    @Override
    public String toString() {
        return IntStream.range(0, this.position.getPosition())
                .mapToObj(i -> MOVE_MARK)
                .collect(Collectors.joining("", getName() + ": ", "\n"));
    }
}
