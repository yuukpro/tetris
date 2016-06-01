package jp.tetris;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * フィールド
 * 
 * 
 * */

public class TetrisPlayFieldController implements Initializable {
	//フィールド
	@FXML
	private GridPane fieldPanel;
	//場
	private Rectangle[][] fieldMatrix;
	//フィールドサイズ
	final int height =40;
	final int width = 20;
	//ブロックサイズ
	final int BLOCK_SIZE = 15;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		fieldPanel.setFocusTraversable(true);
		fieldPanel.requestFocus();
		
	}
	/**
	 * テトリスをするフィールドを作成
	 * */
	public void initFieldView(){
		//テトリスフィールドの大きさ初期化
		fieldMatrix = new Rectangle[this.height][this.width];		
		for (int i = 0; i < this.height; i++) {
			for (int j = 0; j < this.width; j++) {
				Rectangle fieldBlock = new Rectangle(BLOCK_SIZE, BLOCK_SIZE);
				fieldBlock.setFill(Color.AQUA);
				fieldMatrix[i][j] = fieldBlock;
				fieldPanel.add(fieldBlock, j, i );
			}
		}
	}
	
	
	
	
}
