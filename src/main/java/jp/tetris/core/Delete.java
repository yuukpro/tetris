package jp.tetris.core;

public class Delete {
	/***
	 * 列の削除
	 * 
	 * @param i
	 *            行番号
	 */
	public void deleteRow(final int i, final int FIELD_WIDTH, final int[][] blockField) {
		for (int j = 0; j < FIELD_WIDTH; j++) {
			blockField[i][j] = 0;
		}

	
	}
	/***
	 * 削除列を詰める
	 * @param deleteBlock
	 * @param miniCount
	 */
	public void deleteTetoriminoRowPack(final int deleteBlock, final int miniCount, final int FIELD_WIDTH,final int[][] blockField) {
		int[][] cpField = blockField;
		// 削除処理
		if (deleteBlock != 0) {
			for (int i = miniCount; i > 0; i--) {
				for (int j = 0; j < FIELD_WIDTH; j++) {
					blockField[i][j] = cpField[i - deleteBlock][j];
				}

			}
		}
	
	}

}
