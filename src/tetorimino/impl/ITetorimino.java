package tetorimino.impl;


import java.util.ArrayList;
import java.util.List;

import tetris.main.java.MatrixOperations;
import tetorimino.service.TetoriminoService;

/**
 * このクラスではI型テトリミノの形を管理
 * */


public final class ITetorimino implements TetoriminoService {

    private final List<int[][]> tetoriminoShape = new ArrayList<>();

    public ITetorimino() {
        tetoriminoShape.add(new int[][]{
                {0, 0, 0, 1},
                {0, 0, 1, 0},
                {0, 1, 0, 0},
                {1, 0, 0, 0}
        });
        
    }

    @Override
    public List<int[][]> getShape() {
        return MatrixOperations.deepCopyList(tetoriminoShape);
    }

}
