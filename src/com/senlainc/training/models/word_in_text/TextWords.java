package com.senlainc.training.models.word_in_text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextWords {

    private String word;
    private String text;

    public TextWords(String text, String word) {
        this.text = text;
        this.word = word;
    }

    private int getCountOfWordsInText() {
        List<String> words = new ArrayList<>(Arrays.asList(text.split(" ")));
        return (int) words
                .stream()
                .filter(p -> p.toLowerCase().equals(word.toLowerCase())).count();
    }

    @Override
    public String toString() {
        return "\n\tCount of word: "
                + word + " in text: "
                + getCountOfWordsInText();
    }
}
