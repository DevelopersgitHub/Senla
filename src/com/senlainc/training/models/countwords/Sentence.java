package com.senlainc.training.models.countwords;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sentence {
    private String str;

    public Sentence(String str) {
        this.str = str;
    }

    private int parseSentence() {
        return str.split(" ").length;
    }

    private List<String> processingString() {
        List<String> words = null;
        if (str.length() > 0) {
            words = new ArrayList<>(Arrays.asList(str.split(" ")));
        }
        if (words.size() > 0) {
            for (int i = 0; i < words.size(); i++) {
                words.set(i, words.get(i).replaceAll("[^a-zA-Z ]", "").trim().toLowerCase());
                if (words.get(i).length() > 0) {
                    words.set(i, words.get(i).substring(0, 1).toUpperCase() + words.get(i).substring(1));
                }
            }
            words.removeAll(Arrays.asList("", null));
            Collections.sort(words);
        }
        return words;
    }

    @Override
    public String toString() {
        return "\tCount of word in sentence: " + parseSentence() + " "
                + (processingString().size() > 0 ? processingString() : "Нет слов");
    }

}
