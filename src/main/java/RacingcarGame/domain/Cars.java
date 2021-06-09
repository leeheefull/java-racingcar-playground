package RacingcarGame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(String[] values) {
        this.cars = new ArrayList<>();
        for (String car : values) {
            cars.add(new Car(car));
        }
    }

    public boolean isAlone() {
        return this.cars.size() == 1;
    }

    public String getFirstName() {
        return cars.stream()
                .findFirst()
                .map(Car::getName)
                .get();
    }
}
