import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.swing.*;
import java.util.ArrayList;

public class Scene {
    private int id;
    private String story;
    private ArrayList<String> choices = new ArrayList<>();
    private ArrayList<Integer> nextId = new ArrayList<>();

    public Scene(JsonObject json) {
        this.id = json.get("id").getAsInt();
        this.story = json.get("text").getAsString();
        JsonArray temp = json.get("options").getAsJsonArray();
        for (int i = 0; i < temp.size(); i++) {
            JsonObject option = temp.get(i).getAsJsonObject();
            this.choices.add(option.get("msg").getAsString());
            this.nextId.add(option.get("nextId").getAsInt());
        }
    }

    public Scene(int id) {
        this.id = id;
        this.story = JOptionPane.showInputDialog("Skriv din story pls");
        int amount = Integer.parseInt(JOptionPane.showInputDialog("Hur många alternativ behöver du?"));
        for (int i = 0; i < amount; i++) {
            this.choices.add(JOptionPane.showInputDialog("Alternativ nr " + i+1 + "?"));
            this.nextId.add(i + 10); // idk
        }
    }

    public static void main(String[] args) {
        Scene test = new Scene(0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public ArrayList<String> getChoices() {
        return choices;
    }

    public void setChoices(ArrayList<String> choices) {
        this.choices = choices;
    }

    public ArrayList<Integer> getNextId() {
        return nextId;
    }

    public void setNextId(ArrayList<Integer> nextId) {
        this.nextId = nextId;
    }
}
