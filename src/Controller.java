public class Controller {
    Model theModel;

    public Controller(Model theModel) {
        this.theModel = theModel;
    }

    public static void main(String[] args) {
        Model theModel = new Model("story.json");
        System.out.println(theModel.getScene(0));
        System.out.println(theModel.getChoices(0));

    }
}
