package com.lab2.domain.pojo;

import com.lab2.domain.pojo.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PojoTest {
    private List<SentenceMember> sentenceMembers;
    private List<Sentence> sentences;
    private List<Paragraph> paragraphs;
    private Word word;
    private Punctuation punctuation;
    private Sentence sentenceWithDuplicates;
    private Sentence sentenceWithoutDuplicates;
    private Paragraph paragraph;
    private Text text;

    @Before
    public void setUp(){
        word = new Word();
        word.setWord("street");
        punctuation = new Punctuation();
        punctuation.setChars("!!!!".toCharArray());
        sentenceWithDuplicates = new Sentence();
        sentenceWithDuplicates.setSentenceMembers(Arrays.asList(word, punctuation, word));
        sentenceWithDuplicates.setDuplicatedWordsCount(1);
        sentenceWithoutDuplicates = new Sentence();
        sentenceWithoutDuplicates.setSentenceMembers(Arrays.asList(word, punctuation));
        sentenceWithoutDuplicates.setDuplicatedWordsCount(0);
        paragraph = new Paragraph();
        text = new Text();
        sentenceMembers = new ArrayList<>();
        sentences = new ArrayList<>();
        paragraphs = new ArrayList<>();
    }

    @Test
    public void shouldReturn1InParagraphThatHasOneSentenceWithDuplicates(){
        paragraph.setSentences(Arrays.asList(sentenceWithDuplicates, sentenceWithoutDuplicates, sentenceWithoutDuplicates));
        long expected = 1;
        long actual = paragraph.countSentencesWithDuplicatedWords();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn2InTextWithOneParagraphThatHasTwoSentencesWithDuplicates(){
        paragraph.setSentences(Arrays.asList(sentenceWithoutDuplicates, sentenceWithDuplicates, sentenceWithDuplicates));
        paragraphs.add(paragraph);
        text.setParagraphs(paragraphs);
        long expected = 2;
        long actual = text.countSentencesWithDuplicatedWords();

        assertEquals(expected, actual);

    }

    @Test
    public void shouldReturn2InTextWithTwoParagraphsThatHasThreeSentencesWithDuplicates(){
        paragraph.setSentences(Arrays.asList(sentenceWithoutDuplicates, sentenceWithoutDuplicates, sentenceWithDuplicates));
        paragraphs.add(paragraph);
        paragraphs.add(paragraph);
        text.setParagraphs(paragraphs);
        long expected = 2;
        long actual = text.countSentencesWithDuplicatedWords();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn0InTextWithTwoParagraphsThatHasNoSentencesWithDuplicates(){
        paragraph.setSentences(Arrays.asList(sentenceWithoutDuplicates, sentenceWithoutDuplicates, sentenceWithoutDuplicates));
        paragraphs.add(paragraph);
        paragraphs.add(paragraph);
        text.setParagraphs(paragraphs);
        long expected = 0;
        long actual = text.countSentencesWithDuplicatedWords();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn0InTextWith4ParagraphsThatHasNoSentencesWithDuplicates(){
        paragraph.setSentences(Arrays.asList(sentenceWithoutDuplicates, sentenceWithoutDuplicates, sentenceWithoutDuplicates));
        paragraphs.addAll(Arrays.asList(paragraph, paragraph, paragraph, paragraph));
        text.setParagraphs(paragraphs);
        long expected = 0;
        long actual = text.countSentencesWithDuplicatedWords();

        assertEquals(expected, actual);
    }
}
