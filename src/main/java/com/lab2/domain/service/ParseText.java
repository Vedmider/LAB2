package com.lab2.domain.service;

import com.lab2.domain.pojo.*;

import java.util.*;
import java.util.regex.Pattern;

public class ParseText {

    private static final String paragraphSplitPattern = "(?m)(?<=(\\r?\\n))(?=((\\s{2,})|\\t+))";
    private static final String sentenceSplitPattern = "(?m)(?<=\\.)(?=\\s{1,3}\\w|$|\\s+$)";
    private static final String patternSentenceMembersSplit = "\\b";
    private static final String patternWordMatch = "^\\w+$";


    public static String removeAdditionalSpaces(String text) {

        return text.replaceAll(" {2,}", " ");
    }

    public static List<Paragraph> splitToParagraphs(String text) {
        List<Paragraph> paragraphList = new ArrayList<>();
        List<String> paragraphs = Arrays.asList(text.split(paragraphSplitPattern));
        for (String p : paragraphs) {
            Paragraph paragraph = new Paragraph();
            paragraph.setSentences(ParseText
                    .splitToSentences(p));
            paragraphList.add(paragraph);
        }
        return paragraphList;
    }

    public static List<Sentence> splitToSentences(String paragraph) {
        List<Sentence> sentencesList = new ArrayList<>();
        paragraph = ParseText.removeAdditionalSpaces(paragraph);
        List<String> sentences = Arrays.asList(paragraph.split(sentenceSplitPattern));

        for (String s : sentences) {
            Sentence sentence = new Sentence();
            sentence.setSentenceMembers(ParseText.splitToSentenceMembers(s));
            sentence.setDuplicatedWordsCount(ParseText.countDuplicatedWords(sentence
                    .getSentenceMembers()));
            sentencesList.add(sentence);
        }
        return sentencesList;
    }

    public static List<SentenceMember> splitToSentenceMembers(String sentence) {
        List<SentenceMember> sentenceMemberList = new ArrayList<>();

        sentenceMemberList.addAll(ParseText
                .WordsAndPunctuationParse(Arrays
                        .asList(sentence.split(patternSentenceMembersSplit))));

        return sentenceMemberList;
    }

    public static List<SentenceMember> WordsAndPunctuationParse(List<String> sentenceMembers) {
        List<SentenceMember> sentenceMemberList = new ArrayList<>();
        Pattern wordPattern = Pattern.compile(patternWordMatch);

        for (String s : sentenceMembers) {
            if (wordPattern.matcher(s).matches()) {
                Word word = new Word();
                word.setWord(s);
                sentenceMemberList.add(word);
            } else {
                Punctuation punctuation = new Punctuation();
                punctuation.setChars(s.toCharArray());
                sentenceMemberList.add(punctuation);
            }
        }
        return sentenceMemberList;
    }

    public static long countDuplicatedWords(List<SentenceMember> sentenceMembers) {
        long count;
        Set<String> uniqueWords = new HashSet<>();
        count = sentenceMembers.stream()
                .filter(member -> member instanceof Word)
                .map(sentenceMember -> ((Word) sentenceMember).getWord())
                .filter(word -> !uniqueWords.add(word))
                .count();
        return count;
    }


}
