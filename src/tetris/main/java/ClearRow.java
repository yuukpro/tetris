package tetris.main.java;

public final class ClearRow {

    private final int linesRemoved;
    private final int[][] newMatrix;

    /**
     * フィールドの列を一列削る責務を持つ
     * 
     * */
    
    public ClearRow(int linesRemoved, int[][] newMatrix, int scoreBonus) {
        this.linesRemoved = linesRemoved;
        this.newMatrix = newMatrix;
    }

    /**
     * 削除する列を呼び出す
     * */
    public int getLinesRemoved() {
        return linesRemoved;
    }

    public int[][] getNewMatrix() {
        return MatrixOperations.copy(newMatrix);
    }
}
