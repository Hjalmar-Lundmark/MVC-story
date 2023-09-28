import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Model {
    private Gson gson = new Gson();
    private JsonObject[] arrObj;

    public Model(String fileName) {
        try {
            this.arrObj = gson.fromJson(new FileReader(fileName), JsonObject[].class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String getScene(int id) {
        return arrObj[id].get("text").getAsString();
    }

    public String getChoices(int id) {
        JsonArray options = arrObj[id].get("options").getAsJsonArray();
        JsonObject option;
        String optionText = "";
        int optionNext;

        for (int i = 0; i < options.size(); i++) {
            option = options.get(i).getAsJsonObject();
            optionText = option.get("msg").getAsString();
            optionNext = option.get("nextId").getAsInt();

            System.out.println(i+1 + ". " + optionText);
        }

        // scanner in here??? to return chosen option

        return optionText;
    }


}
