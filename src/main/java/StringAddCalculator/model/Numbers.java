package StringAddCalculator.model;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final List<Number> numbers;

    public Numbers() {
        numbers = new ArrayList<>();
    }

    public List<Number> getNumbers() {
        return this.numbers;
    }

    public void addStringNumber(String number) {
        this.numbers.add(new Number(Integer.parseInt(number)));
    }
}
