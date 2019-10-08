import com.lab2.domain.pojo.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SentenceParagraphTextTest {
    private Sentence sentence;
    private Paragraph paragraph;
    private List<SentenceMember> sentenceMembers;
    private List<Sentence> sentences;

    @Before
    public void setUp(){
        paragraph = new Paragraph();
        sentences = new ArrayList<>();
        sentence = new Sentence();
        sentenceMembers = new ArrayList<>();
        Word word = new Word();
        char[] chars = ", !!!, ,, %%".toCharArray();
        Punctuation punctuation = new Punctuation();
        punctuation.setChars(chars);
        word.setWord("Petya");
        sentenceMembers.add(word);
        sentenceMembers.add(word);
        sentenceMembers.add(word);
        sentence.setSentenceMembers(sentenceMembers);
        sentence.setDuplicatedWordsCount(2);
        sentences.add(sentence);
        sentences.add(sentence);
        sentences.add(sentence);
        paragraph.setSentences(sentences);

    }

    @Test
    public void shouldReturnTwoDuplicateCountValueInSentence(){
        long expected = 2;
        long actual = sentence.getDuplicatedWordsCount();

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturn6ValueOfDuplicatesCountInParagraph(){
        long expected = 3;
        long actual = paragraph.countSentencesWithDuplicatedWords();

        assertEquals(expected, actual);
    }
}
