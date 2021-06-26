package racingcarGame.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
    public static final String SEPARATOR = ",";

    private final List<Car> cars;

    public Cars(String input) {
        this.cars = convertStringToList(input);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinner() {
        return this.cars.stream()
                .filter(car -> car.getPosition() == getMaxPosition())
                .collect(Collectors.toList());
    }

    public void moveOrStop() {
        IntStream.range(0, this.cars.size())
                .forEach(i -> this.cars.set(i, this.cars.get(i).move(new RandomMovingStrategy())));
    }

    @Override
    public String toString() {
        return this.cars.stream()
                .map(Car::toString)
                .collect(Collectors.joining("", "", "\n"));
    }

    private List<Car> convertStringToList(String input) {
        return Arrays.stream(splitInput(input))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private String[] splitInput(String input) {
        return input.split(SEPARATOR);
    }

    private int getMaxPosition() {
        return this.cars.stream()
                .map(Car::getPosition)
                .max(Integer::compare)
                .get();
    }
}
