package racingcarGame.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car extends Name {
    private final int position;

    public static final String MOVE_MARK = "-";
    public static final int POSITION_INIT = 0;

    public Car(String name) {
        this(name, POSITION_INIT);
    }

    public Car(String name, int position) {
        super(name);
        this.position = position;
    }

    public int getPosition() {
        return this.position;
    }

    public Car move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            return new Car(getName(), this.position + 1);
        }
        return new Car(getName(), getPosition());
    }

    @Override
    public String toString() {
        return IntStream.range(0, this.position)
                .mapToObj(i -> MOVE_MARK)
                .collect(Collectors.joining("", getName() + ": ", "\n"));
    }
}
