package jp.tetris.controller;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
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
import jp.tetris.tetorimino.RandomTetoriminoGenerator;
import jp.tetris.tetorimino.Tetorimino;
import jp.tetris.core.Fall;

/**
 * テトリスプレイフィールド フィールド内のテトリミノを管理
 * 
 */

public class TetrisPlayFieldController implements Initializable {
	// フィールド
	@FXML
	private GridPane fieldPanel;
	// フィールドサイズ
	private final int FIELD_HEIGHT = 40;
	private final int FIELD_WIDTH = 20;
	// ブロックサイズ
	private final int BLOCK_SIZE = 15;

	// タイムライン
	private Timeline timeLine;
	private int tetoriminoNo = 0;

	// テトリミノ
	private Map<String, Tetorimino> tetoriminoMap = new HashMap<String, Tetorimino>();
	// 落下処理管理
	private Fall fall = new Fall();

	@Override
	public void initialize(final URL location, final ResourceBundle resources) {

		this.fieldPanel.setFocusTraversable(true);
		this.fieldPanel.requestFocus();
		this.operationKeySetting();
		this.initField();
		this.fall.maxPositionMap(this.FIELD_WIDTH);
		this.timeLine();
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
	}

	/**
	 * テトリミノを表示
	 */
	private void drawTetorimino() {

		for (String key : this.tetoriminoMap.keySet()) {
			for (int i = 0; i < Tetorimino.getSIZE(); i++) {
				for (int j = 0; j < this.tetoriminoMap.get(key).getShape().get(0)[i].length; j++) {
					Rectangle tetoriminoBlock = new Rectangle(BLOCK_SIZE, BLOCK_SIZE);
					tetoriminoBlock
							.setFill(Tetorimino.getFillColor(this.tetoriminoMap.get(key).getShape().get(0)[i][j]));
					this.fieldPanel.add(tetoriminoBlock, j + this.tetoriminoMap.get(key).getPositionX(),
							i + this.tetoriminoMap.get(key).getPositionY());

				}
			}

		}
	}

	/**
	 * テトリミノ登録
	 */
	public void entryTetorimino() {
		this.tetoriminoNo++;
		RandomTetoriminoGenerator RandomTetoriminoGenerator = new RandomTetoriminoGenerator();
		this.tetoriminoMap.put(String.valueOf(this.tetoriminoNo), RandomTetoriminoGenerator.createTetoriminoShape());
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

				if (keyEvent.getCode() == KeyCode.LEFT ) {
					System.out.println("左");
					reftMoveTetorimino();

				}
				if (keyEvent.getCode() == KeyCode.RIGHT ) {
					rightMoveTetoriminoe();
					System.out.println("右");

				}
				if (keyEvent.getCode() == KeyCode.UP || keyEvent.getCode() == KeyCode.W) {
					System.out.println("上");
					rotation();
				
				}
			}

		});
	}

	/**
	 * 定期処理登録
	 */
	private void timeLine() {
		timeLine = new Timeline(new KeyFrame(Duration.millis(this.fall.VELOCITY()), ae -> fallTetorimino()));
		timeLine.setCycleCount(Timeline.INDEFINITE);
		timeLine.play();
	}

	private void fallCheck() {
		/**
		 * ture:新しいテトリミノ生成 false:落下処理継続
		 */
		if (this.fall.isFall(this.tetoriminoMap.get(String.valueOf(this.tetoriminoNo)))) {
			this.updateFallposition(String.valueOf(this.tetoriminoNo));
			this.entryTetorimino();
			this.fall.reset();
		} else {
			this.fall.add();
		}
	}

	private void updateFallposition(String key) {
		for (int i = 0; i < Tetorimino.getSIZE(); i++) {
			for (int j = 0; j <this.tetoriminoMap.get(key).getShape().get(0)[i].length ; j++) {
				if (this.tetoriminoMap.get(key).getShape().get(0)[i][j] > 0) {
					this.fall.updatePositionMap(j + this.tetoriminoMap.get(key).getPositionX(),
							i + this.tetoriminoMap.get(key).getPositionY());
				}
			}
		}
	}

	// テトリミノ落下処理
	private void fallTetorimino() {
		// 落下判定
		this.fallCheck();
		this.fieldPanel.getChildren().clear();
		this.initField();
		
			// 操作中テトリミノの座標を一段下げる
			this.tetoriminoMap.get(String.valueOf(this.tetoriminoNo)).setPositionY(this.fall.getFALL_COUNT());
		
		// 登録テトリミノをフィールドに表示
		drawTetorimino();
	}
	private void rightMoveTetoriminoe(){
		if(this.tetoriminoMap.get(String.valueOf(this.tetoriminoNo)).getPositionX()<=this.FIELD_WIDTH){
		this.tetoriminoMap.get(String.valueOf(this.tetoriminoNo)).setPositionX(this.tetoriminoMap.get(String.valueOf(this.tetoriminoNo)).getPositionX()+1);
		}
	}
	private void reftMoveTetorimino(){
		if(this.tetoriminoMap.get(String.valueOf(this.tetoriminoNo)).getPositionX()!=0){
		this.tetoriminoMap.get(String.valueOf(this.tetoriminoNo)).setPositionX(this.tetoriminoMap.get(String.valueOf(this.tetoriminoNo)).getPositionX()-1);
	
		}
	}
	
	public void rotation() {
		this.tetoriminoMap.get(this.tetoriminoNo).Rotation();
	}

}
