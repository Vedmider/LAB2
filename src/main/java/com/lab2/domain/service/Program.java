package com.lab2.domain.service;
import com.lab2.domain.pojo.Text;

public class Program {

    public static void main(String[] args) {

        System.out.println("Start work with text. Text file: \"InputText.txt\"");
        Text text = new Text();
        TextInput input = new TextInput();
        text.setParagraphs(ParseText.splitToParagraphs(input.getInput().get(0)));
        System.out.println("There are " + text.countSentencesWithDuplicatedWords() + " sentences in your text with duplicated words.");

    }
}
