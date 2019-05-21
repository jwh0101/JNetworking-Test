package game;

import lib.misc.Command;
import net.Client;
import net.Server;

import java.awt.*;
import java.io.IOException;
import java.io.Serializable;

public class Game implements Serializable {

    public static final int X = 0;
    public static final int O = 1;

    Server myServer;
    Client myClient;

    private int type;

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
            Command<ClickPackage> spaceClicked = Server.getSpaceClicked();
            ClickPackage packet = new ClickPackage(X, coordinate);
            spaceClicked.setObject(packet);
            myClient.requestCommand(spaceClicked);
        } else {
            spaces[coordinate.x][coordinate.y].setLabel("O");
            Command<ClickPackage> spaceClicked = Server.getSpaceClicked();
            ClickPackage packet = new ClickPackage(O, coordinate);
            spaceClicked.setObject(packet);
            myClient.requestCommand(spaceClicked);
        }
    }

    public static void otherPlayerClick(Object object) {
        ClickPackage packet = (ClickPackage) object;
        int r = packet.getCoordinates().x;
        int c = packet.getCoordinates().y;

        if (packet.getType() == X) {
            //packet.getPanel().getSpaces()[r][c].setLabel("X");
            System.out.println(packet.getCoordinates());
        } else {
            //packet.getPanel().getSpaces()[r][c].setLabel("O");
        }
    }
}
