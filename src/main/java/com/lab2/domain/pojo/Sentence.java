package com.lab2.domain.pojo;

import com.lab2.domain.service.DuplicateCount;

import java.util.List;

public class Sentence implements DuplicateCount {
    private List<SentenceMember> sentenceMembers;
    private long duplicatedWordsCount;
    private boolean hasDuplicates;

    public List<SentenceMember> getSentenceMembers() {
        return sentenceMembers;
    }

    public void setSentenceMembers(List<SentenceMember> sentenceMembers) {
        this.sentenceMembers = sentenceMembers;
    }

    public void setDuplicatedWordsCount(long duplicatedWordsCount) {
        this.duplicatedWordsCount = duplicatedWordsCount;
        if (duplicatedWordsCount > 0) {
            this.hasDuplicates = true;
        }
    }

    public boolean hasDuplicates() {
        return hasDuplicates;
    }

    public long getDuplicatedWordsCount() {
        return duplicatedWordsCount;
    }


    @Override
    public long countSentencesWithDuplicatedWords() {
        return duplicatedWordsCount;
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + sentenceMembers.hashCode();
        return result;
    }

    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Sentence)) {
            return false;
        }

        Sentence sentence = (Sentence) o;

        return sentenceMembers.equals(sentence.getSentenceMembers());
    }
}
