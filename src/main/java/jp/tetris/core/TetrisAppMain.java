package jp.tetris.core;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jp.tetris.controller.TetrisPlayFieldController;

/**
 * ゲームフィールド
 * ゲームフィールド上に表示する項目を管理
 * ゲームフィールド画面表示、テトリスをするフィールド設置、スコア設置（未実装）
 * 
 */

public class TetrisAppMain extends Application{
	public static void  main(final String[] args){
		launch(args);
	}

	@Override
	public void start(final Stage primaryStage) throws Exception {
		
		URL  localtion = getClass().getClassLoader().getResource("jp/tetris/resources/GameField.fxml");
		FXMLLoader  fxmlLoader = new FXMLLoader(localtion);
		Parent root = fxmlLoader.load();
		//フィールドコントローラの呼び出しとFXMLとの関連
		TetrisPlayFieldController tetrisPlayFieldController = fxmlLoader.getController();
		primaryStage.setTitle("テトリス");
		Scene scene = new Scene(root,450,600);
		primaryStage.setScene(scene);
		
		primaryStage.show();
		
		tetrisPlayFieldController.initFieldView();
		
		//テトリミノをフィールドに描画
		tetrisPlayFieldController.drawingTetorimino();
	}
	

}
