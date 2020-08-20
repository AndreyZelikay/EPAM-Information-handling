package by.epam.info_handling.domain.entity;

import by.epam.info_handling.domain.enumeration.SentencePartType;

import java.io.Serializable;
import java.util.Objects;

public class SentencePart implements Serializable {
    private String value;
    private SentencePartType type;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public SentencePartType getType() {
        return type;
    }

    public void setType(SentencePartType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SentencePart)) return false;
        SentencePart that = (SentencePart) o;
        return Objects.equals(value, that.value) &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, type);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SentencePart{");
        sb.append("value='").append(value).append('\'');
        sb.append(", type=").append(type);
        sb.append('}');
        return sb.toString();
    }
}
