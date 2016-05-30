package tetorimino.service;

import tetris.main.java.Down;
import tetris.main.java.MoveEvent;


public interface InputEventListener {

    Down onDownEvent(MoveEvent event);

}
