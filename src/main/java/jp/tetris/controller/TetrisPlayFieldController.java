package jp.tetris.controller;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import jp.tetris.tetorimino.RandomTetoriminoGenerator;
import jp.tetris.tetorimino.Tetorimino;
import jp.tetris.core.Delete;
import jp.tetris.core.Fall;
import jp.tetris.core.Move;
import jp.tetris.core.Timer;

/**
 * テトリスプレイフィールド フィールド内のテトリミノを管理
 * 
 */

public class TetrisPlayFieldController implements Initializable {
	// フィールド
	@FXML
	private GridPane fieldPanel;
	@FXML
	private GridPane nextField;
	@FXML
	private Text gameover;
	// フィールドサイズ
	private final int FIELD_HEIGHT = 40;
	private final int FIELD_WIDTH = 20;
	// ブロックサイズ
	private final int BLOCK_SIZE = 15;

	// フィールド上のテトリミノ状態管理
	private int[][] blockField = new int[this.FIELD_HEIGHT][this.FIELD_WIDTH];

	// テトリミノ
	private Tetorimino moveTetorimino;
	// 次のテトリミノ
	private Tetorimino nextTetorimino;
	// 落下処理管理
	private Fall fall = new Fall();

	// ブロック削除
	private Delete delete = new Delete();

	private Timer timer = new Timer();
	// 座標管理
	private Map<String, Integer> fallPositionMap = new HashMap<String, Integer>();

	@Override
	public void initialize(final URL location, final ResourceBundle resources) {

		this.fieldPanel.setFocusTraversable(true);
		this.fieldPanel.requestFocus();
		this.operationKeySetting();
		this.initField();
		this.fall.maxPositionMap(this.FIELD_WIDTH, this.FIELD_HEIGHT, this.fallPositionMap);
		this.fall.MAX_DEPTH(this.FIELD_HEIGHT - 1);
		this.timer.timeLine(this, this.fall);
		this.gameover.setFill(Color.TRANSPARENT);
		this.entryTetorimino();
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
				this.blockField[i][j] = 0;

			}
		}
	}

	/***
	 * フィールドリセット
	 */
	private void resetField() {
		// テトリスフィールドの大きさ初期化
		for (int i = 0; i < this.FIELD_HEIGHT; i++) {
			for (int j = 0; j < this.FIELD_WIDTH; j++) {

				Rectangle fieldBlock = new Rectangle(BLOCK_SIZE, BLOCK_SIZE);
				// フィールド上にテトリミノが配置されている場合は色をつける
				if (this.blockField[i][j] > 0) {
					if (i == 2) {
						this.timer.stop(this);
					}
					fieldBlock.setFill(Tetorimino.getFillColor(this.blockField[i][j]));
					fieldBlock.setStroke(Color.BLACK);
					this.fallPositionMap.put(j + "@" + i, new Integer(1));
				} else {
					fieldBlock.setFill(Color.TRANSPARENT);
					fieldBlock.setStroke(Color.BLACK);
					this.fallPositionMap.put(j + "@" + i, new Integer(0));
				}
				this.fieldPanel.add(fieldBlock, j, i);

			}
		}
		this.fieldPanel.gridLinesVisibleProperty().set(true);

	}

	/**
	 * テトリミノを表示
	 */
	private void drawTetorimino() {

		for (int i = 0; i < this.moveTetorimino.shape().length; i++) {
			for (int j = 0; j < this.moveTetorimino.shape()[i].length; j++) {
				Rectangle tetoriminoBlock = new Rectangle(BLOCK_SIZE, BLOCK_SIZE);
				tetoriminoBlock.setFill(Tetorimino.getFillColor(this.moveTetorimino.shape()[i][j]));
				this.fieldPanel.add(tetoriminoBlock, j + this.moveTetorimino.getPositionX(),
						i + this.moveTetorimino.getPositionY());
			}
		}
		this.nextField.getChildren().clear();
		for (int i = 0; i < this.nextTetorimino.shape().length; i++) {
			for (int j = 0; j < this.nextTetorimino.shape()[i].length; j++) {
				Rectangle tetoriminoBlock = new Rectangle(BLOCK_SIZE, BLOCK_SIZE);
				tetoriminoBlock.setFill(Tetorimino.getFillColor(this.nextTetorimino.shape()[i][j]));
				this.nextField.add(tetoriminoBlock, j + this.nextTetorimino.getPositionX(),
						i + this.nextTetorimino.getPositionY());
				
			}
		}
	}

	/**
	 * テトリミノ登録
	 */
	private void entryTetorimino() {
		RandomTetoriminoGenerator RandomTetoriminoGenerator = new RandomTetoriminoGenerator();
		if (this.nextTetorimino == null) {
			this.nextTetorimino = RandomTetoriminoGenerator.createTetoriminoShape();
		}
		this.moveTetorimino = this.nextTetorimino;
		this.nextTetorimino = RandomTetoriminoGenerator.createTetoriminoShape();

	}

	/**
	 * キー操作設定
	 */
	private void operationKeySetting() {
		this.fieldPanel.setOnKeyPressed(new EventHandler<KeyEvent>() {
			private Move move = new Move();

			@Override
			public void handle(KeyEvent keyEvent) {
				if (keyEvent.getCode() == KeyCode.DOWN) {
					fallTetorimino();
					keyEvent.consume();
				}

				if (keyEvent.getCode() == KeyCode.LEFT) {
					this.move.reftMoveTetorimino(moveTetorimino, getFallPositionMap());

				}
				if (keyEvent.getCode() == KeyCode.RIGHT) {
					this.move.rightMoveTetoriminoe(moveTetorimino, FIELD_WIDTH, getFallPositionMap());

				}
				if (keyEvent.getCode() == KeyCode.UP || keyEvent.getCode() == KeyCode.W) {

					this.move.rotation(moveTetorimino);

				}
			}

		});
	}

	/***
	 * 移動テトリミノの状態を確認
	 */
	private void fallCheck() {
		/**
		 * ture:新しいテトリミノ生成 false:落下処理継続
		 */
		if (this.fall.isFall(this.moveTetorimino, this.fallPositionMap)) {
			this.fall.updateFallposition(moveTetorimino, fallPositionMap);
			this.update();
			this.entryTetorimino();
			this.fall.reset();
		} else {
			this.fall.add();
		}
	}

	/***
	 * フィールド上のテトリミノの配置状態を更新
	 * 
	 */
	private void update() {
		int deleteBlock = 0;
		int matchCount = 0;
		int miniCount = this.FIELD_HEIGHT;

		this.updateField();

		for (int i = this.FIELD_HEIGHT - 1; i > 0; i--) {
			matchCount = 0;
			for (int j = 0; j < this.FIELD_WIDTH; j++) {
				if (this.blockField[i][j] > 0) {
					matchCount++;
				}
				if (this.FIELD_WIDTH == matchCount) {
					this.delete.deleteRow(i, this.FIELD_WIDTH, this.blockField);

					if (miniCount != 0) {
						miniCount = i;
					}
					deleteBlock++;
				}
			}
		}
		this.delete.deleteTetoriminoRowPack(deleteBlock, miniCount, this.FIELD_WIDTH, this.blockField);

		this.fall.addFallPositionMap(deleteBlock, miniCount, this.fallPositionMap);

	}

	/***
	 * フィールドブロック更新
	 */
	private void updateField() {
		for (int i = 0; i < this.moveTetorimino.getShape().get(0).length; i++) {
			for (int j = 0; j < this.moveTetorimino.shape()[i].length; j++) {

				if (this.moveTetorimino.shape()[i][j] > 0) {
					this.blockField[i + this.moveTetorimino.getPositionY()][j
							+ this.moveTetorimino.getPositionX()] = this.moveTetorimino.shape()[i][j];
				}

			}
		}
	}

	/***
	 * テトリミノ落下処理
	 */
	public void fallTetorimino() {

		// 落下判定
		this.fallCheck();
		this.fieldPanel.getChildren().clear();
		this.resetField();
		// 操作中テトリミノの座標を一段下げる
		this.moveTetorimino.setPositionY(this.fall.getFALL_COUNT());

		// 登録テトリミノをフィールドに表示
		this.drawTetorimino();
	}

	private Map<String, Integer> getFallPositionMap() {
		return fallPositionMap;
	}

	public void gameover() {
		this.gameover.setFill(Color.RED);
	}

}
