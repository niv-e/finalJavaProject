import Controller.OlympicController;
import javafx.application.Application;
import javafx.stage.Stage;
import olympics.OlympicManager;
import view.View;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		OlympicManager theModel = new OlympicManager();
		View theView = new View(primaryStage);
		OlympicController omc = new OlympicController(theModel, theView);
	}

}
