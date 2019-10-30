package com.lab2.domain.pojo;

import com.lab2.domain.service.DuplicateCount;

import java.util.List;

public class Text implements DuplicateCount {
    private List<Paragraph> paragraphs;


    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }

    @Override
    public long countSentencesWithDuplicatedWords() {
        return paragraphs.stream()
                .mapToLong(paragraph -> paragraph.countSentencesWithDuplicatedWords())
                .sum();
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + paragraphs.hashCode();
        return result;
    }

    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Text)) {
            return false;
        }

        Text text = (Text) o;

        return paragraphs.equals(text.getParagraphs());
    }

}
