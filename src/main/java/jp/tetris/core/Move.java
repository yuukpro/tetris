package jp.tetris.core;

import jp.tetris.tetorimino.Tetorimino;
/***
 * 移動
 * テトリミノの移動処理を管理
 * @author yuu
 *
 */
public class Move {

	
	/***
	 * テトリミノ右移動
	 */
	public void rightMoveTetoriminoe(final Tetorimino moveTetorimino,final int FIELD_WIDTH) {
		if (moveTetorimino.getPositionX() + moveTetorimino.shape()[1].length <= FIELD_WIDTH - 1) {
			moveTetorimino.setPositionX(moveTetorimino.getPositionX() + 1);
		}
	}

	/***
	 * テトリミノ左移動
	 */
	public void reftMoveTetorimino(final Tetorimino moveTetorimino) {
		if (moveTetorimino.getPositionX() != 0) {
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
