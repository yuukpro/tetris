package tetorimino.impl;

import tetorimino.service.TetoriminoGeneratorService;
import tetorimino.service.TetoriminoService;


/**
 * 多種多様のテトリミノをランダムで呼び出す
 * 
 * */
public class TetoriminoGenerator implements TetoriminoGeneratorService {


    @Override
    public TetoriminoService getTetorimino() {
     //TODO 現状はI型テトリミノのみ生成する
        return new ITetorimino();
    }
}
