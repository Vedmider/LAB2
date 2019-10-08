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
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        content.add("");
        return content;
    }

}
