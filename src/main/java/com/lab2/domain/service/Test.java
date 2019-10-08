package com.lab2.domain.service;

import com.lab2.domain.pojo.Punctuation;
import com.lab2.domain.pojo.SentenceMember;
import com.lab2.domain.pojo.Text;
import com.lab2.domain.pojo.Word;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        Text text = new Text();
        TextInput input = new TextInput();
        text.setParagraphs(ParseText.splitToParagraphs(input.getInput().get(0)));
        System.out.println(text.countSentencesWithDuplicatedWords());

    }
}
