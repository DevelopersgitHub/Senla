package com.senlainc.training.models.backpackthings;

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

    private double capacity;
    private List<Thing> things = new ArrayList<>();
    private List<Thing> bestItems = null;
    private double bestPrice;

    public List<Thing> getBestItems() {
        return bestItems;
    }

    public Backpack(double capacity) {
        this.capacity = capacity;
        parseJSON();
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
            things.forEach(th -> parseEmployeeObject((JSONObject) th));
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
        List<Thing> things = new ArrayList<>(this.things);
        this.iterateValues(things);
    }

    //calculate full weight set of things
    private double calculateWeight(List<Thing> items) {
        double sumW = 0;
        for (Thing thing : items) {
            sumW += thing.getWeight();
        }
        return sumW;
    }

    //call of full cost set of things
    private double calculatePrice(List<Thing> items) {
        double sumPrice = 0;
        for (Thing thing : items) {
            sumPrice += thing.getCost();
        }
        return sumPrice;
    }

    private void getBestSet(List<Thing> items) {
        if (bestItems == null) {
            if (calculateWeight(items) <= capacity) {
                bestItems = items;
                bestPrice = calculatePrice(items);
            }
        } else {
            if (calculateWeight(items) <= capacity && calculatePrice(items) > bestPrice) {
                bestItems = items;
                bestPrice = calculatePrice(items);
            }
        }
    }

    private void iterateValues(List<Thing> items) {
        if (items.size() > 0)
            getBestSet(items);

        for (int i = 0; i < items.size(); i++) {
            List<Thing> newSet = new ArrayList<>(items);
            newSet.remove(i);
            iterateValues(newSet);
        }
    }

}
