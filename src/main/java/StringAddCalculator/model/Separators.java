package StringAddCalculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Separators {
    private final List<Separator> separators;

    public Separators() {
        this.separators = new ArrayList<>();
        this.separators.add(new Separator(","));
        this.separators.add(new Separator(":"));
    }

    public String getStringSeparators() {
        return this.separators
                .stream()
                .map(Separator::getSeparator)
                .collect(Collectors.joining("|"));
    }

    public void addStringSeparator(String separator) {
        this.separators.add(new Separator(separator));
    }
}
