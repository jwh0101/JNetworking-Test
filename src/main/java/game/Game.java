package game;

import java.awt.*;

public class Game {

    public static final int X = 0;
    public static final int O = 1;

    private int type;

    public Game(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void click(Point coordinate, Button[][] spaces) {
        if (type == X) {
            spaces[coordinate.x][coordinate.y].setLabel("X");
        } else {
            spaces[coordinate.x][coordinate.y].setLabel("O");
        }
    }
}
