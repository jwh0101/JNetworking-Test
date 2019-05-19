package net;

import lib.misc.Command;
import lib.net.JClient;

public class MyClient extends JClient {

    public MyClient(String server_ip, int port, String username) {
        super(server_ip, port, username);
    }

    @Override
    public void display(String s) {

    }

    @Override
    protected void runCommand(Command command) {

    }
}
