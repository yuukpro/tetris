package jp.tetris.tetorimino;

import java.util.ArrayList;
import java.util.List;

/**
 * L型テトリミノ L型テトリミノの形を管理
 */

public class LTetorimino extends Tetorimino{

	private final List<int[][]> shapeTetorimino = new ArrayList<int[][]>();

	public LTetorimino() {

		this.shapeTetorimino.add(new int[][] {  {  3, 0 }, {  3, 0 },{3,3} });
		this.shapeTetorimino.add(new int[][] {  { 3, 3, 3 }, { 3, 0, 0 }});
		this.shapeTetorimino.add(new int[][] { { 3, 3 }, {  3, 0 }, {  3, 0 } });
		this.shapeTetorimino.add(new int[][] {  {3,3},{ 0,3 }, { 0,3 }});
	}

	public List<int[][]> getShape() {
		return shapeTetorimino;

	}

}
