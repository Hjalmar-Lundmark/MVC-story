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

    public JsonObject getScene(int id) {
        //return arrObj[id].get("text").getAsString();
        return arrObj[id];
    }

    /*
    public String getChoice(int id, int i) {
        JsonArray options = arrObj[id].get("options").getAsJsonArray();
        JsonObject option = options.get(i).getAsJsonObject();
        String optionText = option.get("msg").getAsString();

        return optionText;
    }

    public int getNextChoice(int id, int i) {
        JsonArray options = arrObj[id].get("options").getAsJsonArray();
        JsonObject option = options.get(i).getAsJsonObject();
        int optionNext = option.get("nextId").getAsInt();

        return optionNext;
    }
    */
}
