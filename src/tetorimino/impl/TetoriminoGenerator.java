package tetorimino.impl;

import tetorimino.service.TetoriminoGeneratorService;
import tetorimino.service.TetoriminoService;

public class TetoriminoGenerator implements TetoriminoGeneratorService {

    @Override
    public TetoriminoService getTetorimino() {
     
        return new ITetorimino();
    }
}
