package tetris.controller;

import tetorimino.impl.Field;
import tetorimino.service.FieldService;
import tetorimino.service.InputEventListener;
import tetris.main.java.ClearRow;
import tetris.main.java.Down;
import tetris.main.java.MoveEvent;

/**
 * 実行及びテトリスの次の動作を決定する
 * */


public class RunController implements InputEventListener {

	private FieldService field = new Field(35, 20);

	private final TetrisPlayFieldController viewGuiController;

	public RunController(TetrisPlayFieldController c) {
		viewGuiController = c;
		field.createNewTetorimino();
		viewGuiController.initTetrisView(field.getBoardMatrix(), field.getViewData());

	}
	//未実装
	@Override
	public Down onDownEvent(MoveEvent event) {
		ClearRow clearRow = null;
	
		return new Down(clearRow, field.getViewData());
	}


}
