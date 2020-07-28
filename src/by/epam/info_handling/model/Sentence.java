package by.epam.info_handling.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Sentence implements TextElement {
    private List<PartOfSentence> sentenceParts;

    public List<PartOfSentence> getSentenceParts() {
        return sentenceParts;
    }

    public void setSentenceParts(List<PartOfSentence> sentenceParts) {
        this.sentenceParts = sentenceParts;
    }

    public List<Word> getWords(){
        List<Word> words = new LinkedList<>();

        for(PartOfSentence part: sentenceParts) {
            if(part instanceof Word) {
                words.add((Word) part);
            }
        }

        return words;
    }

    @Override
    public String getInitialValue() {
        StringBuilder result = new StringBuilder();

        for(PartOfSentence part : sentenceParts) {
            result.append(part.getContent());
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