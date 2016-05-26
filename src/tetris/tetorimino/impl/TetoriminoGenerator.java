package tetris.tetorimino.impl;

import tetris.tetorimino.service.TetoriminoGeneratorService;
import tetris.tetorimino.service.TetoriminoService;

public class TetoriminoGenerator implements TetoriminoGeneratorService {



    @Override
    public TetoriminoService getTetorimino() {
     
        return new ITetorimino();
    }
}
