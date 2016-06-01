package jp.tetris;


import java.util.ArrayList;
import java.util.List;

/**
 * I型テトリミノの形を管理
 * */

public class ITetorimino {
	
	private final List<int[][]> shapeTetorimino=new ArrayList<int[][]>();
	
	public ITetorimino(){
		
		this.shapeTetorimino.add(new int[][]{
			{0,0,0,1},{0,0,0,1},{0,0,0,1},{0,0,0,1}
		});
			
		}
	public List<int[][]> getShape(){
		return shapeTetorimino;
	
	}
		
	}


