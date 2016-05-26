package tetris.controller;

import tetris.tetorimino.impl.SimpleBoard;
import tetris.tetorimino.service.BoardService;

public class RunController{

    private BoardService board = new SimpleBoard(25, 10);

    private final MainController viewGuiController;

    public RunController(MainController c) {
        viewGuiController = c;
        board.createNewTetorimino();
        viewGuiController.initGameView(board.getBoardMatrix(), board.getViewData());
       
    }

   



}
