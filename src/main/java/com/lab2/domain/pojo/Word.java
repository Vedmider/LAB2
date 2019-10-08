package com.lab2.domain.pojo;

import java.util.Arrays;

public class Word extends  SentenceMember{
    private char[] chars;
    private String word;

    public char[] getChars() {
        return chars;
    }

    public void setChars(char[] chars) {
        this.chars = chars;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + chars.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Word)) {
            return false;
        }

        Word word = (Word) o;

        return Arrays.equals(chars, word.getChars());
    }
}
