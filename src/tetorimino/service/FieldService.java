package tetorimino.service;

import tetris.main.java.ViewTetorimino;

/**
 * このインタフェースではテトリミノの呼び出しとフィールドの大きさを呼び出す
 * */

public interface FieldService {

    boolean createNewTetorimino();

    int[][] getBoardMatrix();

    ViewTetorimino getViewData();

    void newGame();
}
