package racingcarGame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] values) {
        this.cars = new ArrayList<>();
        for (String car : values) {
            cars.add(new Car(car));
        }
    }

    public List<String> getWinnersName() {
        int max = cars.stream()
                .map(Car::getPosition)
                .max(Integer::compare)
                .get();
        return cars.stream()
                .filter(car -> car.getPosition() == max)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public boolean isAlone() {
        return this.cars.size() == 1;
    }

    public List<String> getFirstName() {
        return Collections.singletonList(
                cars.stream()
                        .findFirst()
                        .map(Car::getName)
                        .get()
        );
    }
}
