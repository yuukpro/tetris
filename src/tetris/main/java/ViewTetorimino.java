package tetris.main.java;

public final class ViewTetorimino {

    private final int[][] tetoriminoData;
    private final int xPosition;
    private final int yPosition;
    private final int[][] nextTetoriminoData;

    public ViewTetorimino(int[][] tetoriminoData, int xPosition, int yPosition, int[][] nextTetoriminoData) {
        this.tetoriminoData = tetoriminoData;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.nextTetoriminoData = nextTetoriminoData;
    }

    public int[][] getTetoriminoData() {
        return MatrixOperations.copy(tetoriminoData);
    }

    public int getxPosition() {
        return xPosition;
    }

    public int getyPosition() {
        return yPosition;
    }

    public int[][] getNextTetoriminoData() {
        return MatrixOperations.copy(nextTetoriminoData);
    }
}
