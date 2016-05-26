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
	private static final int BRICK_SIZE = 15;

	@FXML
	private GridPane gamePanel;
	@FXML
	private GridPane tetoriminoPanel;
	private Rectangle[][] displayMatrix;
	private Rectangle[][] rectangles;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		gamePanel.setFocusTraversable(true);
		gamePanel.requestFocus();

	}

	public void initGameView(int[][] boardMatrix, ViewTetorimino viewData) {
		displayMatrix = new Rectangle[boardMatrix.length][boardMatrix[0].length];
		for (int i = 2; i < boardMatrix.length; i++) {
			for (int j = 0; j < boardMatrix[i].length; j++) {
				Rectangle rectangle = new Rectangle(BRICK_SIZE, BRICK_SIZE);
				rectangle.setFill(Color.WHITE);
				displayMatrix[i][j] = rectangle;
				gamePanel.add(rectangle, j, i - 2);
			}
		}

		rectangles = new Rectangle[viewData.getTetoriminoData().length][viewData.getTetoriminoData()[0].length];
		for (int i = 0; i < viewData.getTetoriminoData().length; i++) {
			for (int j = 0; j < viewData.getTetoriminoData()[i].length; j++) {
				Rectangle rectangle = new Rectangle(BRICK_SIZE, BRICK_SIZE);
				rectangle.setFill(getFillColor(viewData.getTetoriminoData()[i][j]));
				rectangles[i][j] = rectangle;
				tetoriminoPanel.add(rectangle, j, i);
			}
		}
		tetoriminoPanel.setLayoutX(gamePanel.getLayoutX() + viewData.getxPosition() * tetoriminoPanel.getVgap()
				+ viewData.getxPosition() * BRICK_SIZE);
		tetoriminoPanel.setLayoutY(-42 + gamePanel.getLayoutY() + viewData.getyPosition() * tetoriminoPanel.getHgap()
				+ viewData.getyPosition() * BRICK_SIZE);

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
