package jp.tetris.tetorimino;

import java.util.ArrayList;
import java.util.List;

/**
 * J型テトリミノ J型テトリミノの形を管理
 */

public class JTetorimino extends Tetorimino {

	private final List<int[][]> shapeTetorimino = new ArrayList<int[][]>();

	public JTetorimino() {

		this.shapeTetorimino.add(new int[][] { { 0, 4 }, { 0, 4 }, { 4, 4 } });
		this.shapeTetorimino.add(new int[][] { { 4, 0, 0 }, { 4, 4, 4 }, { 0, 0, 0 } });
		this.shapeTetorimino.add(new int[][] { { 4, 4 }, { 4, 0 }, { 4, 0 } });
		this.shapeTetorimino.add(new int[][] { { 4, 4 }, { 0, 4 }, { 0, 4 } });
	}

	public List<int[][]> getShape() {
		return shapeTetorimino;

	}

}
