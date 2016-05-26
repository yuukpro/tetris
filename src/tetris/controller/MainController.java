package tetris.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import tetris.main.java.ViewTetorimino;


public class MainController implements Initializable {
	private static final int BLOCK_SIZE = 15;

	@FXML
	private GridPane fieldPanel;
	@FXML
	private GridPane tetoriminoPanel;
	private Rectangle[][] displayMatrix;
	private Rectangle[][] rectangles;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		fieldPanel.setFocusTraversable(true);
		fieldPanel.requestFocus();

	}

	public void initTetrisView(int[][] boardMatrix, ViewTetorimino view) {
		displayMatrix = new Rectangle[boardMatrix.length][boardMatrix[0].length];
		for (int i = 2; i < boardMatrix.length; i++) {
			for (int j = 0; j < boardMatrix[i].length; j++) {
				Rectangle fieldBlock = new Rectangle(BLOCK_SIZE, BLOCK_SIZE);
				fieldBlock.setFill(Color.WHITE);
				displayMatrix[i][j] = fieldBlock;
				fieldPanel.add(fieldBlock, j, i - 2);
			}
		}

		rectangles = new Rectangle[view.getTetoriminoData().length][view.getTetoriminoData()[0].length];
		for (int i = 0; i < view.getTetoriminoData().length; i++) {
			for (int j = 0; j < view.getTetoriminoData()[i].length; j++) {
				Rectangle tetoriminoBlock = new Rectangle(BLOCK_SIZE, BLOCK_SIZE);
				tetoriminoBlock.setFill(getFillColor(view.getTetoriminoData()[i][j]));
				rectangles[i][j] = tetoriminoBlock;
				tetoriminoPanel.add(tetoriminoBlock, j, i);
			}
		}
		tetoriminoPanel.setLayoutX(fieldPanel.getLayoutX() + view.getxPosition() * tetoriminoPanel.getVgap()
				+ view.getxPosition() * BLOCK_SIZE);
		tetoriminoPanel.setLayoutY(fieldPanel.getLayoutY() + view.getyPosition() * tetoriminoPanel.getHgap()
				+ view.getyPosition() * BLOCK_SIZE);
		
		

	}

	private Paint getFillColor(int i) {
		Paint returnPaint;
		switch (i) {
		case 0:
			returnPaint = Color.WHITE;
			break;
		case 1:
			returnPaint = Color.AQUA;
			break;
		default:
			returnPaint = Color.WHITE;
			break;
		}
		return returnPaint;
	}

}
