package game;

import java.awt.*;
import java.io.Serializable;

public class ClickPackage implements Serializable {

    private int type;
    private Point coordinates;

    public ClickPackage(int type, Point coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }

    public int getType() {
        return type;
    }

    public Point getCoordinates() {
        return coordinates;
    }

}
