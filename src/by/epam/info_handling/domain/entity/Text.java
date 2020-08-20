package by.epam.info_handling.domain.entity;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Text implements Serializable {
    private transient List<TextElement> elements;

    public List<TextElement> getElements() {
        return elements;
    }

    public void setElements(List<TextElement> elements) {
        this.elements = elements;
    }

    public String getInitialValue() {
        StringBuilder result = new StringBuilder();

        for(TextElement element: elements) {
            result.append(element.getInitialValue());
        }

        return result.toString();
    }

    public List<Sentence> getSentences() {
        List<Sentence> sentences = new LinkedList<>();

        for(TextElement element: elements) {
            if(element instanceof Sentence) {
                sentences.add((Sentence) element);
            }
        }

        return sentences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text = (Text) o;
        return Objects.equals(elements, text.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements);
    }

    @Override
    public String toString() {
        return "Text{" +
                "elements=" + elements +
                '}';
    }
}
