package racingcarGame.domain;

import racingcarGame.exception.GameCancelFlagException;
import racingcarGame.exception.InputEmptyException;
import racingcarGame.exception.InputNullException;
import racingcarGame.utils.Constants;
import racingcarGame.utils.RandomGenerator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame implements Recordable {
    private final List<Car> cars;
    private final int moveCnt;

    public RacingGame(String input, int moveCnt) {
        validate(input, moveCnt);
        this.cars = convertStringToList(input);
        this.moveCnt = moveCnt;
        play();
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinner() {
        if (isAlone()) {
            return getFirstCar();
        }
        return this.cars
                .stream()
                .filter(car -> car.getPosition() == getMaxPosition())
                .collect(Collectors.toList());
    }

    @Override
    public StringBuilder getLog() {
        return log;
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

    private List<Car> convertStringToList(String input) {
        return Arrays.stream(splitInput(input))
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private String[] splitInput(String input) {
        return input.split(Constants.SEPARATOR);
    }

    private void play() {
        int cnt = this.moveCnt;
        while (cnt-- > 0) {
            moveOrStop();
        }
    }

    private void moveOrStop() {
        for (Car car : this.cars) {
            if (RandomGenerator.moveOrStop()) {
                car.move();
            }
            log.append(car.getMoveLog());
        }
        log.append("\n");
    }

    private boolean isAlone() {
        return this.cars.size() == Constants.ALONE;
    }

    private List<Car> getFirstCar() {
        return Collections.singletonList(
                this.cars
                        .stream()
                        .findFirst()
                        .get()
        );
    }

    private int getMaxPosition() {
        return this.cars
                .stream()
                .map(Car::getPosition)
                .max(Integer::compare)
                .get();
    }
}
