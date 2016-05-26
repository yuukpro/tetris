package tetris.controller;

import tetris.tetorimino.impl.Board;
import tetris.tetorimino.service.BoardService;

public class RunController{

    private BoardService board = new Board(25, 10);

    private final MainController viewGuiController;

    public RunController(MainController c) {
        viewGuiController = c ;
        board.createNewTetorimino();
        viewGuiController.initGameView(board.getBoardMatrix(), board.getViewData());
       
    }

   



}
