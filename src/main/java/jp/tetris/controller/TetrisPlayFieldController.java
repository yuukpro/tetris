package jp.tetris.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import jp.tetris.tetorimino.ITetorimino;
import jp.tetris.tetorimino.RandomTetoriminoGenerator;
import jp.tetris.tetorimino.ShapeTetorimino;

/**
 * フィールド フィールド内のテトリミノを管理
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
	RandomTetoriminoGenerator RTG = new RandomTetoriminoGenerator();


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		this.fieldPanel.setFocusTraversable(true);
		this.fieldPanel.requestFocus();

	}

	/**
	 * テトリスをするフィールドを作成 
	 */
	public void initField() {
		// テトリスフィールドの大きさ初期化

		for (int i = 0; i < this.FIELD_HEIGHT; i++) {
			for (int j = 0; j < this.FIELD_WIDTH; j++) {
				Rectangle fieldBlock = new Rectangle(BLOCK_SIZE, BLOCK_SIZE);
				fieldBlock.setFill(Color.ANTIQUEWHITE);
				this.fieldPanel.add(fieldBlock, j, i);
			}
		}
	}

	/**
	 * テトリミノを表示
	 */
	public void drawingTetorimino() {
		
		// TODO ランダムにテトリミノを呼び出し
		ShapeTetorimino tetorimino = this.RTG.getRandomTetorimino();

		for (int i = 0; i < tetorimino.getShape().get(0).length; i++) {
			for (int j = 0; j < tetorimino.getShape().get(0)[0].length; j++) {
				Rectangle tetoriminoBlock = new Rectangle(BLOCK_SIZE, BLOCK_SIZE);
				tetoriminoBlock.setFill(ITetorimino.getFillColor(tetorimino.getShape().get(0)[i][j]));
				this.fieldPanel.add(tetoriminoBlock, j, i);
			}
		}

	}


}
