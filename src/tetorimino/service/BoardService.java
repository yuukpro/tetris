package tetorimino.service;

import tetris.main.java.ViewTetorimino;

public interface BoardService {

    boolean createNewTetorimino();

    int[][] getBoardMatrix();

    ViewTetorimino getViewData();

    void newGame();
}
