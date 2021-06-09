package racingcarGame.domain;

import racingcarGame.exception.GameCancelFlagException;
import racingcarGame.exception.InputEmptyException;
import racingcarGame.exception.InputNullException;
import racingcarGame.utils.Constants;
import racingcarGame.utils.RandomGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private final List<Car> cars;
    private final int moveCnt;

    public RacingGame(String input, int moveCnt) {
        validate(input, moveCnt);
        this.cars = new ArrayList<>();
        for (String car : splitInput(input)) {
            this.cars.add(new Car(car));
        }
        this.moveCnt = moveCnt;
        play();
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinCars() {
        if (isAlone()) {
            return getFirstCar();
        }
        return this.cars.stream()
                .filter(car -> car.getPosition() == getMaxPosition())
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return this.cars
                .stream()
                .map(Car::getPosition)
                .max(Integer::compare)
                .get();
    }

    private boolean isAlone() {
        return this.cars.size() == 1;
    }

    private List<Car> getFirstCar() {
        return Collections.singletonList(
                this.cars.stream()
                        .findFirst()
                        .get()
        );
    }

    private void play() {
        int cnt = this.moveCnt;
        while (cnt-- > 0) {
            for (Car car : this.cars) {
                if (RandomGenerator.moveOrStop()) {
                    car.move();
                }
            }
        }
    }

    private String[] splitInput(String input) {
        return input.split(Constants.SEPARATOR);
    }

    private void validate(String input, int moveCnt) {
        if (input == null) {
            throw new InputNullException();
        }
        if (input.equals("")) {
            throw new InputEmptyException();
        }
        if (moveCnt == 0) {
            throw new GameCancelFlagException();
        }
    }
}
