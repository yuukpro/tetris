package jp.tetris;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * ゲームフィールド
 * ゲームフィールドの管理
 * 
 * */

public class TetrisAppMain extends Application{
	public static void  main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//FXML読み込み処理
		URL localtion = getClass().getClassLoader().getResource("jp/tetris/resources/GameField.fxml");
		FXMLLoader fxmlLoader = new FXMLLoader(localtion);
		Parent root = fxmlLoader.load();
		//フィールドコントローラの呼び出しとFXMLとの関連
		TetrisPlayFieldController tetrisPlayFieldController = fxmlLoader.getController();
		//ゲームフィールドタイトル設定
		primaryStage.setTitle("テトリス");
		//ゲームフィールドサイズ設定
		Scene scene = new Scene(root,450,600);
		primaryStage.setScene(scene);
		//ゲームフィールド表示
		primaryStage.show();
		//テトリスフィールドを初期化
		tetrisPlayFieldController.initFieldView();
	}
	

}
