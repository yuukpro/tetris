package jp.tetris.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import jp.tetris.tetorimino.RandomTetoriminoBuilder;
import jp.tetris.tetorimino.Tetorimino;

/**
 * フィールド フィールド内のテトリミノを管理
 * 
 */

public class TetrisPlayFieldController implements Initializable {
	// フィールド
	@FXML
	private GridPane fieldPanel;
	@FXML
	private GridPane baPanel;
	// フィールドサイズ
	private final int FIELD_HEIGHT = 40;
	private final int FIELD_WIDTH = 20;
	// ブロックサイズ
	private final int BLOCK_SIZE = 15;
	private final RandomTetoriminoBuilder RandomTetoriminoBuilder = new RandomTetoriminoBuilder();
	//タイムライン
	private Timeline timeLine;

	@Override
	public void initialize(final URL location, final ResourceBundle resources) {

		this.fieldPanel.setFocusTraversable(true);
		this.fieldPanel.requestFocus();
		operationKeySetting();
		initField();

	}

	/**
	 * テトリスをするフィールドを作成
	 */
	private void initField() {
		// テトリスフィールドの大きさ初期化

		for (int i = 0; i < this.FIELD_HEIGHT; i++) {
			for (int j = 0; j < this.FIELD_WIDTH; j++) {
				Rectangle fieldBlock = new Rectangle(BLOCK_SIZE, BLOCK_SIZE);
				fieldBlock.setFill(Color.TRANSPARENT);
				this.fieldPanel.add(fieldBlock, j, i);
			}
		}
		/**
		 *定期処理 
		 */
		timeLine();
	}

	/**
	 * テトリミノを表示
	 */
	public void drawTetorimino() {

		// TODO ランダムにテトリミノを呼び出し
		Tetorimino tetorimino = this.RandomTetoriminoBuilder
				.createTetoriminoShape();

		for (int i = 0; i < Tetorimino.getSIZE(); i++) {
			for (int j = 0; j < Tetorimino.getSIZE(); j++) {
				Rectangle tetoriminoBlock = new Rectangle(BLOCK_SIZE,
						BLOCK_SIZE);
				tetoriminoBlock.setFill(Tetorimino.getFillColor(tetorimino
						.getShape().get(0)[i][j]));
				this.baPanel.add(tetoriminoBlock, j, i);

			}
		}
	}

	/**
	 * キー操作設定
	 */
	private void operationKeySetting() {
		this.fieldPanel.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent keyEvent) {

				if (keyEvent.getCode() == KeyCode.DOWN) {
					System.out.println("key_down");
					fallTetorimino();
					keyEvent.consume();
				}
			}
		});
	}
	/**
	 * 定期処理登録
	 */
	private void timeLine() {
		timeLine = new Timeline(new KeyFrame(Duration.millis(500),
				ae -> fallTetorimino()));
		timeLine.setCycleCount(Timeline.INDEFINITE);
		timeLine.play();
	}

	// TODO キー操作落下
	private void fallTetorimino() {
		
		System.out.println("key_down");
	}

}
