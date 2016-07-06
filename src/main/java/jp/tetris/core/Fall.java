package jp.tetris.core;

import java.util.HashMap;
import java.util.Map;

import jp.tetris.tetorimino.Tetorimino;

/**
 * 落下 テトリミノの落下判定及び落下速度を登録
 */
public class Fall {
	// 落下カウント
	private int FALL_COUNT;
	// 落下速度
	private int VELOCITY = 300;
	// 座標管理
	private Map<String, Integer> fallPositionMap = new HashMap<String, Integer>();

	public void maxPositionMap(final int width) {
		for (int i = 0; i <= width; i++) {
			this.fallPositionMap.put(String.valueOf(i), new Integer(40));
		}
	}

	/***
	 * 
	 * @param positionX
	 * @param positionY
	 */
	public void updatePositionMap(final int positionX, final int positionY) {
		if (this.maxPositionY(positionX) >= positionY) {
			this.fallPositionMap.put(String.valueOf(positionX), new Integer(positionY));
		}
	}

	/***
	 * 
	 * @param tetorimino
	 * @return true:落下可能 false:落下不可
	 */
	public Boolean isFall(final Tetorimino tetorimino) {
		Boolean check = false;
		for (int i = 0; i < tetorimino.shape().length; i++) {
			for (int j = 0; j < tetorimino.shape()[i].length; j++) {
				if (tetorimino.shape()[i][j] > 0) {
					if (this.fallPositionMap.get(String.valueOf(j + tetorimino.getPositionX())).intValue() - 1 == i
							+ tetorimino.getPositionY()) {
						check = true;
					}
				}
			}

		}
		return check;
	}

	/***
	 * 列削除処理によるポジションマップの更新
	 */
	public void addFallPositionMap(final int deleteBlock, final int miniCount) {
		if (deleteBlock != 0) {
			for (String key : fallPositionMap.keySet()) {

				this.fallPositionMap.put(key, new Integer(deleteBlock + this.fallPositionMap.get(key).intValue()));

			}
		}
	}

	/**
	 * 
	 * @return 落下ポイント
	 */
	public int getFALL_COUNT() {
		return this.FALL_COUNT;
	}

	/**
	 * 落下ポイントの加算
	 */
	public void add() {
		this.FALL_COUNT++;
	}

	/**
	 * 
	 */
	public void reset() {
		this.FALL_COUNT = 0;
	}

	/***
	 * 
	 * @return 落下速度
	 */
	public int VELOCITY() {
		return this.VELOCITY;
	}

	/***
	 * 
	 * @param x
	 *            X軸を渡す
	 * @return Y軸の限界値を返す
	 */
	public int maxPositionY(final int x) {
		return this.fallPositionMap.get(String.valueOf(x)).intValue();
	}

}
