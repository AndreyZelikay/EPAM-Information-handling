package by.epam.info_handling.domain.entity;

import java.io.Serializable;
import java.util.Objects;

public class Heading implements TextElement, Serializable {

    private String textContent;

    public Heading() {
    }

    public Heading(String textContent){
        this.textContent = textContent;
    }

    @Override
    public String getInitialValue() {
        return textContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Heading)) return false;
        Heading heading = (Heading) o;
        return Objects.equals(textContent, heading.textContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(textContent);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Heading{");
        sb.append("textContent='").append(textContent).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
