package jp.tetris.core;

/**
 * 落下 テトリミノの落下判定及び落下速度を登録
 */
public class Fall {
	// 落下カウント
	private int FALL_COUNT;
	private int VELOCITY = 300;

	public Boolean isFall(final int tetoriminoPositionY, final int FIELD_HEIGHT) {

		if (tetoriminoPositionY >= FIELD_HEIGHT - 4) {

			return true;

		} else {
			return false;
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
	public int getVELOCITY() {
		return this.VELOCITY;
	}

}
