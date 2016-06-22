package jp.tetris.tetorimino;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * ランダムテトリミノ生成 テトリミノの種類を格納,ランダムにフィールド上に生成
 * 
 */

public class RandomTetoriminoBuilder {

	private final List<Tetorimino> tetoriminoList;

	private final Deque<Tetorimino> nextTetoriminos = new ArrayDeque<>();

	// ランダム生成用にテトリミノリストを作成
	public RandomTetoriminoBuilder() {
		this.tetoriminoList = new ArrayList<>();
		this.tetoriminoList.add(new ITetorimino());
		this.tetoriminoList.add(new TTetorimino());
		this.nextTetoriminos.add(this.tetoriminoList.get(ThreadLocalRandom.current().nextInt(this.tetoriminoList.size())));
	}

	public Tetorimino createTetoriminoShape() {
		if (this.nextTetoriminos.size() <= 1) {
			this.nextTetoriminos.add(this.tetoriminoList.get(ThreadLocalRandom.current().nextInt(this.tetoriminoList.size())));
		}
		return nextTetoriminos.poll();
	}

}
