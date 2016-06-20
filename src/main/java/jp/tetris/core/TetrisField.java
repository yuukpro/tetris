package jp.tetris.core;

import java.io.IOException;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jp.tetris.controller.TetrisPlayFieldController;

/**
 * テトリスフィールド 
 * ゲームフィールド上に表示する項目を管理 ゲームフィールド画面表示、テトリスをするフィールド設置、スコア設置（未実装）
 * 
 */

public class TetrisField extends Application {

	private TetrisPlayFieldController tetrisPlayFieldController;

	public static void main(final String[] args) {
		launch(args);
	}

	@Override
	public void start(final Stage primaryStage) throws Exception {

		/**
		 * 画面の初期設定
		 */
		initTetris(primaryStage);
		// テトリミノをフィールドに描画
		this.tetrisPlayFieldController.drawTetorimino();
	}

	/**
	 * テトリスの初期作成
	 */
	public void initTetris(final Stage primaryStage) throws IOException {
		URL localtion = getClass().getClassLoader().getResource("jp/tetris/resources/GameField.fxml");
		FXMLLoader fxmlLoader = new FXMLLoader(localtion);
		Parent root = fxmlLoader.load();
		this.tetrisPlayFieldController = fxmlLoader.getController();
		primaryStage.setTitle("テトリス");
		Scene tetrisField = new Scene(root, 450, 600);
		primaryStage.setScene(tetrisField);
		primaryStage.show();
	}

}