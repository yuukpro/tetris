package jp.tetris.tetorimino;

import java.util.ArrayList;
import java.util.List;

/**
 * Iテトリミノ
 * I型テトリミノの形を管理
 */

public class ITetorimino extends Tetorimino implements ShapeTetorimino {

	private final List<int[][]> shapeTetorimino = new ArrayList<int[][]>();

	public ITetorimino() {

		this.shapeTetorimino.add(new int[][] { { 0, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 } });
		this.shapeTetorimino.add(new int[][] { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0 } });
	}

	public List<int[][]> getShape() {
		return shapeTetorimino;

	}

}
