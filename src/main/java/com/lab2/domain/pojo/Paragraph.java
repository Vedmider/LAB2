package com.lab2.domain.pojo;

import com.lab2.domain.service.DuplicateCount;

import java.util.List;

public class Paragraph implements DuplicateCount {
    private List<Sentence> sentences;


    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    @Override
    public long countSentencesWithDuplicatedWords() {
        return sentences.stream()
                .filter(sentence -> sentence.hasDuplicates()).count();
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + sentences.hashCode();
        return result;
    }

    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Paragraph)) {
            return false;
        }

        Paragraph paragraph = (Paragraph) o;

        return sentences.equals(paragraph.getSentences());
    }
}
