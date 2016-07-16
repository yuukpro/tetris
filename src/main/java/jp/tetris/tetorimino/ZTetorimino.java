package jp.tetris.tetorimino;

import java.util.ArrayList;
import java.util.List;

/**
 * Z型テトリミノ Z型テトリミノの形を管理
 */

public class ZTetorimino extends Tetorimino{

	private final List<int[][]> shapeTetorimino = new ArrayList<int[][]>();

	public ZTetorimino() {

		this.shapeTetorimino.add(new int[][] { {7, 7, 0 }, { 0, 7, 7 } });
		this.shapeTetorimino.add(new int[][] {  {0,7},{ 7, 7 }, { 7, 0,0 }});

	}

	public List<int[][]> getShape() {
		return shapeTetorimino;

	}

}
