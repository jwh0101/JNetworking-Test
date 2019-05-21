package net;

import game.ClickPackage;
import game.Game;
import lib.misc.Command;
import lib.net.JServer;

import java.io.IOException;

public class Server extends JServer {

    private static Command<ClickPackage> spaceClicked = new Command<>("spaceClicked");

    public Server(int port) {
        super(port);

        Command.addCommand(spaceClicked);
    }

    public static void main(String[] args) {
        Server myServer = new Server(25569);
        myServer.start();
    }

    @Override
    public void display(String s) {
        System.out.println(s);
    }

    @Override
    protected void runCustomCommand(Command command, String s) {

        //try {

            if (command.equals(spaceClicked)) {

            }

        //} catch (IOException | ClassNotFoundException e) {
           // e.printStackTrace();
        //}

    }

    public static Command<ClickPackage> getSpaceClicked() {
        return spaceClicked;
    }
}
