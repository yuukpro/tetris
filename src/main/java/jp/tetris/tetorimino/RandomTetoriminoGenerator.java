package jp.tetris.tetorimino;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomTetoriminoGenerator {

	/**
	 * テトリミノの種類を格納,ランダムにフィールド上に生成
	 * 
	 */
	private final List<ShapeTetorimino> tetoriminoList;

	private final Deque<ShapeTetorimino> nextTetoriminos = new ArrayDeque<>();

	//ランダム生成用にテトリミノリストを作成
	public RandomTetoriminoGenerator() {
		this.tetoriminoList = new ArrayList<>();
		this.tetoriminoList.add(new ITetorimino());
		this.tetoriminoList.add(new TTetorimino());
        this.nextTetoriminos.add(this.tetoriminoList.get(ThreadLocalRandom.current().nextInt(this.tetoriminoList.size())));
	}

	public ShapeTetorimino getRandomTetorimino() {
		if (this.nextTetoriminos.size() <= 1) {
			this.nextTetoriminos.add(this.tetoriminoList.get(ThreadLocalRandom.current().nextInt(this.tetoriminoList.size())));
		}
		return nextTetoriminos.poll();
	}

}
