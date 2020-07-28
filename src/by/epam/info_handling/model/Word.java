package by.epam.info_handling.model;

import java.util.Objects;

public class Word implements PartOfSentence {

    private String value;

    public Word() {
    }

    public Word(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(value, word.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String getContent() {
        return value;
    }

    @Override
    public String toString() {
        return "Word{" +
                "value='" + value + '\'' +
                '}';
    }
}
