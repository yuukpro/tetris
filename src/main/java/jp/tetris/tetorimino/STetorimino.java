package jp.tetris.tetorimino;

import java.util.ArrayList;
import java.util.List;

/**
 * S型テトリミノ S型テトリミノの形を管理
 */

public class STetorimino extends Tetorimino{

	private final List<int[][]> shapeTetorimino = new ArrayList<int[][]>();

	public STetorimino() {

		this.shapeTetorimino.add(new int[][] { {0, 6, 6 }, { 6, 6, 0 } });
		this.shapeTetorimino.add(new int[][] {  {6,0},{ 6, 6 }, { 0, 6 }});

	}

	public List<int[][]> getShape() {
		return shapeTetorimino;

	}

}
