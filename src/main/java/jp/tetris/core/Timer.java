package jp.tetris.core;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import jp.tetris.controller.TetrisPlayFieldController;

/***
 * タイマー テトリス時間を管理
 * 
 * @author yuu
 *
 */
public class Timer {
	// タイムライン
	private Timeline timeLine;
	private boolean isTimer = true;

	/**
	 * 定期処理登録
	 * 
	 * @param tetrisPlayFieldController
	 * @param fall
	 */
	public void timeLine(final TetrisPlayFieldController tetrisPlayFieldController, final Fall fall) {
		timeLine = new Timeline(
				new KeyFrame(Duration.millis(fall.VELOCITY()), ae -> tetrisPlayFieldController.fallTetorimino()));
		timeLine.setCycleCount(Timeline.INDEFINITE);
		timeLine.play();
	}

	/***
	 * 定期処理停止 ゲームオーバー
	 */
	public void stop(final TetrisPlayFieldController tetrisPlayFieldController) {
		this.timeLine.stop();
		this.isTimer = false;
		tetrisPlayFieldController.gameover();
	}

	public boolean isTimer() {

		return this.isTimer;
	}

}
