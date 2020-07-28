package by.epam.info_handling.model;

import java.util.Objects;

public class Delimiter implements PartOfSentence{

    private String value;

    public Delimiter() {
    }

    public Delimiter(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String getContent() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Delimiter delimiter = (Delimiter) o;
        return Objects.equals(value, delimiter.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "Delimiter{" +
                "value='" + value + '\'' +
                '}';
    }
}
