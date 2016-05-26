package tetris.tetorimino.service;

import tetris.main.java.ClearRow;
import tetris.main.java.ViewTetorimino;

public interface BoardService {

    boolean moveTetoriminoDown();

    boolean moveTetoriminoLeft();

    boolean moveTetoriminoRight();

    boolean rotateLeftTetorimino();

    boolean createNewTetorimino();

    int[][] getBoardMatrix();

    ViewTetorimino getViewData();

    void mergeTetoriminoToBackground();

    ClearRow clearRows();


    void newGame();
}
