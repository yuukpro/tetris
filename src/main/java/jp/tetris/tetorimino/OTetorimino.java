package jp.tetris.tetorimino;

import java.util.ArrayList;
import java.util.List;

/**
 * Oテトリミノ O型テトリミノの形を管理
 */

public class OTetorimino extends Tetorimino {

	private final List<int[][]> shapeTetorimino = new ArrayList<int[][]>();

	public OTetorimino() {

		this.shapeTetorimino.add(new int[][] { { 5,5 },{ 5,5} });

	}

	public List<int[][]> getShape() {
		return shapeTetorimino;

	}

}
