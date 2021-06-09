package stringAddCalculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Numbers {
    private final List<Number> numbers;

    public Numbers() {
        this.numbers = new ArrayList<>();
    }

    public Numbers(String[] numbers) {
        this.numbers = Arrays.stream(numbers)
                .map(Integer::parseInt)
                .map(Number::new)
                .collect(Collectors.toList());
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    public int addNumbers() {
        return this.numbers
                .stream()
                .mapToInt(Number::getNumber)
                .reduce(Integer::sum)
                .getAsInt();
    }
}
