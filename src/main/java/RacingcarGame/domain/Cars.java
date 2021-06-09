package RacingcarGame.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(String input) {
        this.cars = new ArrayList<>();
        cars.add(new Car(input));
    }

    public List<Car> getCars() {
        return cars;
    }

    public boolean isAlone() {
        return this.cars.size() == 1;
    }
}
