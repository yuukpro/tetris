package tetris.tetorimino.impl;


import java.awt.*;

import tetris.main.java.ClearRow;
import tetris.main.java.MatrixOperations;
import tetris.main.java.NextShapeInfo;
import tetris.main.java.TetoriminoRotator;
import tetris.main.java.ViewTetorimino;
import tetris.tetorimino.service.BoardService;
import tetris.tetorimino.service.TetoriminoGeneratorService;
import tetris.tetorimino.service.TetoriminoService;

public class Board implements BoardService {

    private final int width;
    private final int height;
    private final TetoriminoGeneratorService tetoriminoGenerator;
    private final TetoriminoRotator tetoriminoRotator;
    private int[][] currentGameMatrix;
    private Point currentOffset;
  

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        currentGameMatrix = new int[width][height];
        tetoriminoGenerator = new TetoriminoGenerator();
        tetoriminoRotator = new TetoriminoRotator();
        
    }

    @Override
    public boolean moveTetoriminoDown() {
        int[][] currentMatrix = MatrixOperations.copy(currentGameMatrix);
        Point p = new Point(currentOffset);
        p.translate(0, 1);
        boolean conflict = MatrixOperations.intersect(currentMatrix, tetoriminoRotator.getCurrentShape(), (int) p.getX(), (int) p.getY());
        if (conflict) {
            return false;
        } else {
            currentOffset = p;
            return true;
        }
    }


    @Override
    public boolean moveTetoriminoLeft() {
        int[][] currentMatrix = MatrixOperations.copy(currentGameMatrix);
        Point p = new Point(currentOffset);
        p.translate(-1, 0);
        boolean conflict = MatrixOperations.intersect(currentMatrix, tetoriminoRotator.getCurrentShape(), (int) p.getX(), (int) p.getY());
        if (conflict) {
            return false;
        } else {
            currentOffset = p;
            return true;
        }
    }

    @Override
    public boolean moveTetoriminoRight() {
        int[][] currentMatrix = MatrixOperations.copy(currentGameMatrix);
        Point p = new Point(currentOffset);
        p.translate(1, 0);
        boolean conflict = MatrixOperations.intersect(currentMatrix, tetoriminoRotator.getCurrentShape(), (int) p.getX(), (int) p.getY());
        if (conflict) {
            return false;
        } else {
            currentOffset = p;
            return true;
        }
    }

    @Override
    public boolean rotateLeftTetorimino() {
        int[][] currentMatrix = MatrixOperations.copy(currentGameMatrix);
        NextShapeInfo nextShape = tetoriminoRotator.getNextShape();
        boolean conflict = MatrixOperations.intersect(currentMatrix, nextShape.getShape(), (int) currentOffset.getX(), (int) currentOffset.getY());
        if (conflict) {
            return false;
        } else {
            tetoriminoRotator.setCurrentShape(nextShape.getPosition());
            return true;
        }
    }

    @Override
    public boolean createNewTetorimino() {
        TetoriminoService currentBrick = tetoriminoGenerator.getTetorimino();
        tetoriminoRotator.setBrick(currentBrick);
        currentOffset = new Point(4, 0);
        return MatrixOperations.intersect(currentGameMatrix, tetoriminoRotator.getCurrentShape(), (int) currentOffset.getX(), (int) currentOffset.getY());
    }

    @Override
    public int[][] getBoardMatrix() {
        return currentGameMatrix;
    }

    @Override
    public ViewTetorimino getViewData() {
        return new ViewTetorimino(tetoriminoRotator.getCurrentShape(), (int) currentOffset.getX(), (int) currentOffset.getY(), tetoriminoGenerator.getTetorimino().getShape().get(0));
    }

    @Override
    public void mergeTetoriminoToBackground() {
        currentGameMatrix = MatrixOperations.merge(currentGameMatrix, tetoriminoRotator.getCurrentShape(), (int) currentOffset.getX(), (int) currentOffset.getY());
    }

    @Override
    public ClearRow clearRows() {
        ClearRow clearRow = MatrixOperations.checkRemoving(currentGameMatrix);
        currentGameMatrix = clearRow.getNewMatrix();
        return clearRow;

    }

   

    @Override
    public void newGame() {
        currentGameMatrix = new int[width][height];
        
        createNewTetorimino();
    }
}
