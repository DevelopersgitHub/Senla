package com.senlainc.training.models.backpack_of_things;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Backpack {
    private static final String PATH = "C:\\Users\\Компьютер\\IdeaProjects\\senla\\src\\com\\senlainc\\training\\resources\\things.json";

    private int capacity;
    private List<Thing> things = new ArrayList<>();

    public Backpack(int capacity) {
        this.capacity = capacity;
    }

    /**
     * method proccesing JSON
     */
    private void parseJSON() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(PATH));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray things = (JSONArray) jsonObject.get("things");
            things.forEach(th -> this.parseEmployeeObject((JSONObject) th));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private void parseEmployeeObject(JSONObject obj) {
        long id = (long) obj.get("id");
        String name = (String) obj.get("name");
        double weight = (double) obj.get("weight");
        double cost = (double) obj.get("cost");
        Thing thing = new Thing(id, name, weight, cost);
        this.things.add((thing));
    }

    public void buildBackpack() {
        this.parseJSON();
        int capacity = this.capacity;
        for (Thing thing : this.things) {
            if (capacity > 0) {
                if (capacity >= thing.getWeight()) {
                    capacity -= thing.getWeight();
                } else {
                    this.things.remove(thing);
                }
            } else {
                break;
            }
        }
    }
}
