package tetris.main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tetris.controller.TetrisPlayFieldController;
import tetris.controller.RunController;
import java.net.URL;


/**
 * テトリスを起動して、テトリスプレイフィールドの大きさを管理する
 * */

public class TetrisAppMain extends Application {

	public static void main(String[] args) {
        launch(args);
    }
	
	@Override
	public void start(Stage tetrisStage) throws Exception {

        URL location = getClass().getClassLoader().getResource("tetris/fxml/field.fxml");
		FXMLLoader fxmlLoader = new FXMLLoader(location);
		Parent root = fxmlLoader.load();
		TetrisPlayFieldController mainController = fxmlLoader.getController();
		tetrisStage.setTitle("テトリス");
        Scene scene = new Scene(root, 450, 550);
        tetrisStage.setScene(scene);
        tetrisStage.show();
        new RunController(mainController);
	}
	

}
