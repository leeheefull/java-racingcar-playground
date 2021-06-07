package StringAddCalculator.model;

public class Separator {
    private String separator;

    public Separator() {
        this.separator = "[,:]";
    }

    public String getSeparator() {
        return separator;
    }

    public void add(String separator) {
        this.separator += "|" + separator;
    }
}
