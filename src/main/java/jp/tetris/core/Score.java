package jp.tetris.core;

public class Score {

	private int score = 0;

	public String add() {
		this.score++;
		return String.valueOf(this.score);

	}
	public String deletePoint(){
		this.score +=10;
		return String.valueOf(this.score);
	}
}
