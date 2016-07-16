package jp.tetris.core;

import java.util.Map;

import jp.tetris.tetorimino.Tetorimino;

/***
 * 移動 テトリミノの移動処理を管理
 * 
 * @author yuu
 *
 */
public class Move {

	/***
	 * テトリミノ右移動
	 */
	public void rightMoveTetoriminoe(final Tetorimino moveTetorimino, final int FIELD_WIDTH,
			final Map<String, Integer> fallPositionMap) {

		Boolean moveOk = true;
		for (int i = 0; i < moveTetorimino.shape().length; i++) {
			for (int j = 0; j < moveTetorimino.shape()[i].length; j++) {
				if (moveTetorimino.shape()[i][j] != 0 && (fallPositionMap
						.get(String.valueOf(
								(j + moveTetorimino.getPositionX()) + 1 + "@" + (i + moveTetorimino.getPositionY())))
						.intValue() != 0)) {
					moveOk = false;
				}
			}
		}
		// テトリミノを右に移動
		if (moveOk && moveTetorimino.getPositionX() + moveTetorimino.shape()[1].length <= FIELD_WIDTH - 1) {
			moveTetorimino.setPositionX(moveTetorimino.getPositionX() + 1);
		}

	}

	/***
	 * テトリミノ左移動
	 */
	public void reftMoveTetorimino(final Tetorimino moveTetorimino, final Map<String, Integer> fallPositionMap) {
		Boolean moveOk = true;
		try {
			for (int i = 0; i < moveTetorimino.shape().length; i++) {
				for (int j = 0; j < moveTetorimino.shape()[i].length; j++) {
					if (moveTetorimino.shape()[i][j] != 0 && (fallPositionMap.get(String.valueOf(
							(j + moveTetorimino.getPositionX()) - 1 + "@" + (i + moveTetorimino.getPositionY())))
							.intValue() != 0)) {
						moveOk = false;
					}
				}
			}
		} catch (NullPointerException e) {

		}
		// テトリミノを左に移動
		if (moveOk && moveTetorimino.getPositionX() != 0) {
			moveTetorimino.setPositionX(moveTetorimino.getPositionX() - 1);

		}
	}

	/***
	 * 回転
	 */
	public void rotation(final Tetorimino moveTetorimino) {
		moveTetorimino.Rotation();
	}

}
