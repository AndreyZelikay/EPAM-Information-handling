package by.epam.info_handling.domain.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Sentence implements TextElement, Serializable {

    private static final long serialVersionUID = 1L;

    private List<SentencePart> sentenceParts;

    public List<SentencePart> getSentenceParts() {
        return sentenceParts;
    }

    public void setSentenceParts(List<SentencePart> sentenceParts) {
        this.sentenceParts = sentenceParts;
    }

    @Override
    public String getInitialValue() {
        StringBuilder result = new StringBuilder();

        for (SentencePart part : sentenceParts) {
            result.append(part.getValue());
        }

        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sentence sentence = (Sentence) o;
        return Objects.equals(sentenceParts, sentence.sentenceParts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentenceParts);
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "sentenceParts=" + sentenceParts +
                '}';
    }
}
