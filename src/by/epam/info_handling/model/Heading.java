package by.epam.info_handling.model;

public class Heading implements TextElement {

    private String textContent;

    public Heading() {
    }

    public Heading(String textContent){
        this.textContent = textContent;
    }

    public String getTextContent() {
        return textContent;
    }

    @Override
    public String getInitialValue() {
        return textContent;
    }
}
