package net;

import lib.exceptions.ClientNotFoundException;
import lib.misc.Command;
import lib.net.JServer;

import java.io.IOException;

public class MyServer extends JServer {

    public MyServer(int port) {
        super(port);
    }

    @Override
    public void display(String s) {
        System.out.println(s);
    }

    @Override
    protected void runCustomCommand(Command command, String s) throws IOException, ClientNotFoundException {

    }
}
