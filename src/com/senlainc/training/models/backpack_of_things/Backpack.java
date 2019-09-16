package com.senlainc.training.models.backpack_of_things;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Backpack {
    private static final String PATH = "C:\\Users\\Компьютер\\IdeaProjects\\senla\\src\\com\\senlainc\\training\\resources\\things.json";

    private int capacity;
    List<Thing> things = new ArrayList<>();

    public Backpack(int capacity) {
        this.capacity = capacity;
    }

    /**
     * method proccesing JSON
     */
    public void parseJSON() {


    }
}
