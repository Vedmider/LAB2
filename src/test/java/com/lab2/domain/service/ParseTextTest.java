package com.lab2.domain.service;

import com.lab2.domain.pojo.Paragraph;
import com.lab2.domain.pojo.SentenceMember;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ParseTextTest {
    private List<Paragraph> paragraphs;

    @Before
    public void setUp() {
        paragraphs = new ArrayList<>();
    }

    @Test
    public void shouldReplaceMultipleSpacesInStringToOneSpace() {
        String expected = " spring autumn java ";
        String actual = ParseText.removeAdditionalSpaces("       spring      autumn   java    ");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnListOfTwoParagraphs() {
        paragraphs.addAll(ParseText.splitToParagraphs("   sentence. sentence.\r\n" +
                "     sentence. sentence."));
        int expected = 2;
        int actual = paragraphs.size();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnListOfThreeSentences() {
        int expected = 3;
        int actual = ParseText.splitToSentences(" Hello my friend!. I want to tell you. I do not know what.").size();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnListOf9SentenceMembers() {
        int expected = 4;
        List<SentenceMember> sentenceMemberList = ParseText.splitToSentenceMembers(" Someone knows about it!.");
        int actual = sentenceMemberList.size();
    }

    @Test
    public void shouldCount5DuplicatesInSentence() {
        long expected = 5;
        long actual = ParseText
                .countDuplicatedWords(ParseText
                        .splitToSentenceMembers(" Someone tell Someone that  Someone tell and one day will tell Someone"));

        assertEquals(expected, actual);
    }
}
