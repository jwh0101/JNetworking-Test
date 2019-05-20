package game;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Game game = null;

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if (input.equalsIgnoreCase("x")) {
            game = new Game(Game.X);
        } else if (input.equalsIgnoreCase("o")) {
            game = new Game(Game.O);
        } else {
            main(null);
        }

        Panel panel = new Panel();
        panel.initialize(game);
    }
}
