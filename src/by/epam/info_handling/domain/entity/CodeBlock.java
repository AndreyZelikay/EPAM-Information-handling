package by.epam.info_handling.domain.entity;

import java.io.Serializable;
import java.util.Objects;

public class CodeBlock implements TextElement, Serializable {
    private String textContent;

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    @Override
    public String getInitialValue() {
        return textContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodeBlock codeBlock = (CodeBlock) o;
        return Objects.equals(textContent, codeBlock.textContent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(textContent);
    }

    @Override
    public String toString() {
        return "CodeBlock{" +
                "textContent='" + textContent + '\'' +
                '}';
    }
}
