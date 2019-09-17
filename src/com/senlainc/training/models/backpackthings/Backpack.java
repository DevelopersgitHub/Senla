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
        this.iterateValues(this.things);
    }

    //calculate full weight set of things
    private double calculateWeight() {
        double sumW = 0;
        for (Thing thing : this.things) {
            sumW += thing.getCost();
        }
        return sumW;
    }

    //call of full cost set of things
    private double calculatePrice() {
        double sumPrice = 0;
        for (Thing thing : this.things) {
            sumPrice += thing.getCost();
        }
        return sumPrice;
    }

    private void getBestSet() {
        if (bestItems == null) {
            if (calculateWeight() <= capacity) {
                bestItems = this.things;
                bestPrice = calculatePrice();
            }
        } else {
            if (calculateWeight() <= capacity && calculatePrice() > bestPrice) {
                bestItems = this.things;
                bestPrice = calculatePrice();
            }
        }
    }

    private void iterateValues(List<Thing> items) {
        if (items.size() > 0) {
            getBestSet();
        } else {
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            List<Thing> newSet = new ArrayList<>(items);
            newSet.remove(i);
            iterateValues(newSet);
        }
    }

    @Override
    public String toString() {
        return "\tIn the backpack with capacity: "
                + capacity +
                " fit " + things.size() +
                " things";
    }

}
