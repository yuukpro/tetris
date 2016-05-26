package tetris.main.java;

import tetris.tetorimino.service.TetoriminoService;

public class TetoriminoRotator {

    private TetoriminoService tetorimino;
    private int currentShape = 0;

    public NextShapeInfo getNextShape() {
        int nextShape = currentShape;
        nextShape = (++nextShape) % tetorimino.getShape().size();
        return new NextShapeInfo(tetorimino.getShape().get(nextShape), nextShape);
    }

    public int[][] getCurrentShape() {
        return tetorimino.getShape().get(currentShape);
    }

    public void setCurrentShape(int currentShape) {
        this.currentShape = currentShape;
    }

    public void setBrick(TetoriminoService tetorimino) {
        this.tetorimino = tetorimino;
        currentShape = 0;
    }


}
