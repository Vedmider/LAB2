package com.lab2.domain.pojo;

import java.util.Arrays;

public class Punctuation extends SentenceMember {
    private char[] chars;

    @Override
    public char[] getChars() {
        return chars;
    }

    @Override
    public void setChars(char[] chars) {
        this.chars = chars;
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
        if (!(o instanceof Punctuation)) {
            return false;
        }

        Punctuation punctuation = (Punctuation) o;

        return Arrays.equals(chars, punctuation.getChars());
    }
}
