package net;

import lib.misc.Command;
import lib.net.JClient;

import java.io.Serializable;

public class Client extends JClient {

    public Client(String server_ip, int port, String username) {
        super(server_ip, port, username);
    }

    @Override
    public void display(String s) {
        System.out.println(s);
    }

    @Override
    protected void runCommand(Command command) {

    }
}
