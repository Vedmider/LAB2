package com.lab2.domain.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TextInput implements InputService {

    public List<String> getInput(){
        List<String> content = new ArrayList<>();

        try{
            byte[] encoded = Files.readAllBytes(Paths.get("InputText.txt"));
            content.add(new String(encoded, StandardCharsets.UTF_8));
            System.out.println("Loaded text to String with length " + content.get(0).length());
            System.out.println("Loaded text:\n");
            System.out.println(content.get(0) + "\n");
            System.out.println("Formatted text is:");
            System.out.println(ParseText.removeAdditionalSpaces(content.get(0)));
            return content;
        } catch (IOException e) {
            System.out.println("Can not load text from text file!");
            e.printStackTrace();
        }

        content.add("");
        return content;
    }

}
