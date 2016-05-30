package tetris.controller;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import tetorimino.service.InputEventListener;
import tetris.main.java.Down;
import tetris.main.java.EventSource;
import tetris.main.java.EventType;
import tetris.main.java.MoveEvent;
import tetris.main.java.NotificationPanel;
import tetris.main.java.ViewTetorimino;

/**
 * このクラスではテトリスをするフィールドの表示及びテトリスにより発生するスコア画面の表示を責務とする
 */

public class TetrisPlayFieldController implements Initializable {
	private static final int BLOCK_SIZE = 15;

	@FXML
	private GridPane fieldPanel;
	@FXML
	private GridPane tetoriminoPanel;
	private Rectangle[][] displayMatrix;
	private Rectangle[][] rectangles;


    private Timeline timeLine;

    private InputEventListener eventListener;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		fieldPanel.setFocusTraversable(true);
		fieldPanel.requestFocus();
		fieldPanel.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent keyEvent) {

				if (keyEvent.getCode() == KeyCode.UP || keyEvent.getCode() == KeyCode.W) {
					System.out.println("キー入力上");
				}

			}
		});
		

	}



	public void initTetrisView(int[][] boardMatrix, ViewTetorimino view) {
		displayMatrix = new Rectangle[boardMatrix.length][boardMatrix[0].length];
		for (int i = 2; i < boardMatrix.length; i++) {
			for (int j = 0; j < boardMatrix[i].length; j++) {
				Rectangle fieldBlock = new Rectangle(BLOCK_SIZE, BLOCK_SIZE);
				fieldBlock.setFill(Color.TRANSPARENT);
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
		
		   timeLine = new Timeline(new KeyFrame(
	                Duration.millis(400),
	                ae -> moveDown(new MoveEvent(EventType.DOWN, EventSource.THREAD))
	        ));
		   
		   timeLine.setCycleCount(Timeline.INDEFINITE);
	        timeLine.play();

	}

	
    private void moveDown(MoveEvent event) {
 
            Down down = eventListener.onDownEvent(event);
            if (down.getClearRow() != null && down.getClearRow().getLinesRemoved() > 0) {
               
            }
            refreshBrick(down.getViewData());
        tetoriminoPanel.requestFocus();
    }
    
    private void refreshBrick(ViewTetorimino brick) {
        
    	tetoriminoPanel.setLayoutX(fieldPanel.getLayoutX() + brick.getxPosition() * fieldPanel.getVgap() + brick.getxPosition() * BLOCK_SIZE);
    	tetoriminoPanel.setLayoutY(-42 + fieldPanel.getLayoutY() + brick.getyPosition() * fieldPanel.getHgap() + brick.getyPosition() * BLOCK_SIZE);
            for (int i = 0; i < brick.getTetoriminoData().length; i++) {
                for (int j = 0; j < brick.getTetoriminoData()[i].length; j++) {
                    setRectangleData(brick.getTetoriminoData()[i][j], rectangles[i][j]);
                
            }
           
        }
    }

    private void setRectangleData(int color, Rectangle rectangle) {
        rectangle.setFill(getFillColor(color));
        rectangle.setArcHeight(9);
        rectangle.setArcWidth(9);
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
