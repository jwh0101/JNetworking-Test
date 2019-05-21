package game;

import lib.misc.Command;
import net.Client;
import net.Server;

import java.awt.*;
import java.io.IOException;
import java.io.Serializable;

public class Game {

    public static final int X = 0;
    public static final int O = 1;

    private Client myClient;

    private int type;

    private static Panel panel;

    public Game(int type) {
        this.type = type;

        if (type == X) {
            myClient = new Client("localhost", 25569, "X");
            myClient.connect();
        } else {
            myClient = new Client("localhost", 25569, "O");
            myClient.connect();
        }
    }

    public int getType() {
        return type;
    }

    public void click(Point coordinate, Button[][] spaces, Panel panel) throws IOException {
        if (type == X) {
            spaces[coordinate.x][coordinate.y].setLabel("X");
            Command<ClickPackage> spaceClicked = new Command<>(Server.getSpaceClicked().getName());
            ClickPackage packet = new ClickPackage(X, coordinate);
            spaceClicked.setObject(packet);
            myClient.requestCommand(spaceClicked);
            spaceClicked.setObject(null);
        } else {
            spaces[coordinate.x][coordinate.y].setLabel("O");
            Command<ClickPackage> spaceClicked = new Command<>(Server.getSpaceClicked().getName());
            ClickPackage packet = new ClickPackage(O, coordinate);
            spaceClicked.setObject(packet);
            myClient.requestCommand(spaceClicked);
        }
    }


}
