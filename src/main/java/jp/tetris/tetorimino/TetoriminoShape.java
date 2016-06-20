package jp.tetris.tetorimino;

import java.util.List;

/**
 * 形状 
 * テトリミノの形を呼び出す
 */
public interface TetoriminoShape {

	List<int[][]> getShape();
}