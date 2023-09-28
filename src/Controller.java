import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.Scanner;

public class Controller {
    Model theModel;

    public Controller(Model theModel) {
        this.theModel = theModel;
        play();
    }

    public void play() {
        Scanner question = new Scanner(System.in);
        int ans;
        int place = 0;

        // story starts
        while (true) {
            //JsonElement id = arrObj[place].get("id");
            String text = theModel.getScene(place).get("text").getAsString();
            JsonArray options = theModel.getScene(place).get("options").getAsJsonArray();

            System.out.println(text);

            if (options.isEmpty()) {
                break;
            }

            for (int i = 0; i < 2; i++) {
                JsonObject option = options.get(i).getAsJsonObject();
                String optionText = option.get("msg").getAsString();

                System.out.println(i+1 + ". " + optionText);
            }

            //scanner listen
            System.out.println("Write the corresponding number below then press enter.");
            ans = question.nextInt();

            JsonObject option = options.get(ans-1).getAsJsonObject();
            place = option.get("nextId").getAsInt();
        }
    }

    public static void main(String[] args) {
        Model theModel = new Model("story.json");
        Controller theController = new Controller(theModel);
        // ask for restart controller, restarting the program
    }
}
