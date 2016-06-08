package jp.tetris.tetorimino;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 * テトリミノ
 * 
 * テトリミノの回転、色、移動を管理
 */
public class Tetorimino {
	
	
	/**TODO
	 * 回転処理
	 */
	public void Rotation(){
		
	}
	/**
	 * 色管理
	 * 
	 */ 
	@SuppressWarnings("unused")
	public static Paint getFillColor(final int i) {
		Paint returnPaint;
		switch (i) {
		case 0:
			returnPaint = Color.TRANSPARENT;
			break;
		case 1:
			returnPaint = Color.CYAN;
			break;
		case 2:
			returnPaint = Color.BLUEVIOLET;
			break;
		default:
			returnPaint = Color.TRANSPARENT;
			break;
		}
		return returnPaint;
	}
}

