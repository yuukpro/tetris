package jp.tetris;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

/**
 * フィールド
 * フィールド内のテトリミノを管理
 * 
 * */

public class TetrisPlayFieldController implements Initializable {
	//フィールド
	@FXML
	private GridPane fieldPanel;
	private Rectangle[][] fieldMatrix;
	private Rectangle[][] tetoriminoMatrix;
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
	
	
	/*
	 * I型テトリミノを表示
	 * **/
	public void initDrawingTetorimino(){
		Tetorimino teto= new Tetorimino();
		//TODO 描画サンプル
		List<int[][]> t = teto.getTetorimino().getShape();
		tetoriminoMatrix = new Rectangle[t.get(0).length][t.get(0)[0].length];	
		for(int i= 0; i<t.get(0).length;i++){
			for(int j =0;j<t.get(0)[0].length; j++){
				Rectangle tetoriminoBlock = new Rectangle(BLOCK_SIZE,BLOCK_SIZE);
				tetoriminoBlock.setFill(getFillColor(t.get(0)[i][j]));
				tetoriminoMatrix[i][j] =tetoriminoBlock;
				fieldPanel.add(tetoriminoBlock, j, i);
			}
		}

	}
	
	//テトリミノの色設定
	private Paint getFillColor(int i) {
        Paint returnPaint;
        switch (i) {
            case 0:
                returnPaint = Color.TRANSPARENT;
                break;
            case 1:
                returnPaint = Color.BLUE;
                break;
               //フィールドのデフォルトの色
            default:
                returnPaint = Color.AQUA;
                break;
        }
        return returnPaint;
    }

	
}
