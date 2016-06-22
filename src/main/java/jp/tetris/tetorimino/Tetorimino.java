package jp.tetris.tetorimino;

import java.util.List;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 * テトリミノ
 * 
 * テトリミノの回転、色、移動を管理
 */
public class Tetorimino {
	/**
	 * テトリミノ描画サイズ
	 */
	private final static int SIZE = 4;
	/**
	 * テトリミノ座標
	 */
	private int positionX = 1;
	private int positionY = 1;
	private List<int[][]> Shape;
	/**
	 * TODO 回転処理
	 */
	public void Rotation() {

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

	public static int getSIZE() {
		return SIZE;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public List<int[][]> getShape() {
		return Shape;
	}

	public void setShape(List<int[][]> shape) {
		Shape = shape;
	}
}
