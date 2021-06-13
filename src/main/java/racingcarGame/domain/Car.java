package racingcarGame.domain;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Car extends Name implements Movable {
    public static final String MOVE_MARK = "-";

    private final int position;

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

    @Override
    public Car move() {
        return new Car(getName(), this.position + 1);
    }

    @Override
    public boolean isMove() {
        return new Random().nextBoolean();
    }

    @Override
    public String toString() {
        return IntStream.range(0, this.position)
                .mapToObj(i -> MOVE_MARK)
                .collect(Collectors.joining("", getName() + ": ", "\n"));
    }
}
