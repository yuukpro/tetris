package jp.tetris.tetorimino;

import java.util.ArrayList;
import java.util.List;

/**
 * T型テトリミノ T型テトリミノの形を管理
 */

public class TTetorimino extends Tetorimino implements TetoriminoShape {

	private final List<int[][]> shapeTetorimino = new ArrayList<int[][]>();

	public TTetorimino() {

		this.shapeTetorimino.add(new int[][] { { 0, 0, 0, 2 }, { 0, 0, 2, 2 }, { 0, 0, 0, 2 }, { 0, 0, 0, 0 } });
		this.shapeTetorimino.add(new int[][] { { 0, 0, 0, 0 }, { 0, 0, 2, 0 }, { 0, 2, 2, 2 }, { 0, 0, 0, 0 } });
	}

	public List<int[][]> getShape() {
		return shapeTetorimino;

	}

}
