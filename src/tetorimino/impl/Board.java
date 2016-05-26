package tetorimino.impl;


import java.awt.*;
import tetris.main.java.MatrixOperations;
import tetris.main.java.TetoriminoRotator;
import tetris.main.java.ViewTetorimino;
import tetorimino.service.BoardService;
import tetorimino.service.TetoriminoGeneratorService;
import tetorimino.service.TetoriminoService;

public class Board implements BoardService {

    private final int width;
    private final int height;
    private final TetoriminoGeneratorService tetoriminoGenerator;
    private final TetoriminoRotator tetoriminoRotator;
    private int[][] currentMatrix;
    private Point currentOffset;
  

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        currentMatrix = new int[width][height];
        tetoriminoGenerator = new TetoriminoGenerator();
        tetoriminoRotator = new TetoriminoRotator();
        
    }

    @Override
    public boolean createNewTetorimino() {
        TetoriminoService currentBrick = tetoriminoGenerator.getTetorimino();
        tetoriminoRotator.setBrick(currentBrick);
        currentOffset = new Point(4, 0);
        return MatrixOperations.intersect(currentMatrix, tetoriminoRotator.getCurrentShape(), (int) currentOffset.getX(), (int) currentOffset.getY());
    }

    @Override
    public int[][] getBoardMatrix() {
        return currentMatrix;
    }

    @Override
    public ViewTetorimino getViewData() {
        return new ViewTetorimino(tetoriminoRotator.getCurrentShape(), (int) currentOffset.getX(), (int) currentOffset.getY(), tetoriminoGenerator.getTetorimino().getShape().get(0));
    }

   


   

    @Override
    public void newGame() {
        currentMatrix = new int[width][height];
        
        createNewTetorimino();
    }
}
