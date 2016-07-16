package jp.tetris.core;

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
	// 最大深さ
	private int MAX_DEPTH;

	public void maxPositionMap(final int width, final int hight, final Map<String, Integer> fallPositionMap) {
		for (int i = 0; i <= width; i++) {
			for (int j = 0; j <= hight; j++) {

				fallPositionMap.put(String.valueOf(i + "@" + j), new Integer(0));

			}
		}
	}

	/***
	 * 
	 * @param positionX
	 * @param positionY
	 */
	public void updatePositionMap(final int positionX, final int positionY,
			final Map<String, Integer> fallPositionMap) {
		fallPositionMap.put(String.valueOf(positionX + "@" + positionY), new Integer(1));

	}

	/***
	 * 
	 * @param tetorimino
	 * @return true:落下可能 false:落下不可
	 */
	public Boolean isFall(final Tetorimino tetorimino, final Map<String, Integer> fallPositionMap) {
		Boolean check = false;
		for (int i = 0; i < tetorimino.shape().length; i++) {
			for (int j = 0; j < tetorimino.shape()[i].length; j++) {

				if (tetorimino.shape()[i][j] != 0 && (fallPositionMap
						.get(String
								.valueOf((j + tetorimino.getPositionX()) + "@" + (i + tetorimino.getPositionY() + 1)))
						.intValue() != 0 || (i + tetorimino.getPositionY()) == this.MAX_DEPTH)) {
					check = true;

				}
			}

		}
		return check;
	}

	/***
	 * 列削除処理によるポジションマップの更新
	 */
	public void addFallPositionMap(final int deleteBlock, final int miniCount,
			final Map<String, Integer> fallPositionMap) {
		if (deleteBlock != 0) {
			for (String key : fallPositionMap.keySet()) {

				fallPositionMap.put(key, new Integer(deleteBlock + fallPositionMap.get(key).intValue()));

			}
		}
	}

	/***
	 * テトリミノの座標登録
	 */
	public void updateFallposition(final Tetorimino moveTetorimino, final Map<String, Integer> fallPositionMap) {
		for (int i = 0; i < moveTetorimino.shape().length; i++) {
			for (int j = 0; j < moveTetorimino.shape()[i].length; j++) {
				if (moveTetorimino.shape()[i][j] != 0) {

					this.updatePositionMap(j + moveTetorimino.getPositionX(), i + moveTetorimino.getPositionY(),
							fallPositionMap);
				}
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
	 * フィールド最大深さ
	 * 
	 * @param MAX_DEPTH
	 */
	public void MAX_DEPTH(final int MAX_DEPTH) {
		this.MAX_DEPTH = MAX_DEPTH;
	}

}
