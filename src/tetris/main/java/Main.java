package tetris.main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tetris.controller.MainController;
import tetris.controller.RunController;
import java.net.URL;

public class Main extends Application {

	public static void main(String[] args) {
        launch(args);
    }
	
	@Override
	public void start(Stage primaryStage) throws Exception {

        URL location = getClass().getClassLoader().getResource("tetris/fxml/field.fxml");
		FXMLLoader fxmlLoader = new FXMLLoader(location);
		Parent root = fxmlLoader.load();
		MainController f = fxmlLoader.getController();
		primaryStage.setTitle("テトリス");
        Scene scene = new Scene(root, 400, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
        new RunController(f);
	}
	

}
