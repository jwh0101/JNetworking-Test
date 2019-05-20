package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JFrame implements ActionListener {

    private Game game;

    private Button[][] spaces = new Button[3][3];

    public void initialize(Game game) {
        setSize(500, 500);
        setLayout(new GridLayout(3, 3));

        for (int r = 0; r < spaces.length; r++) {
            for (int c = 0; c < spaces[r].length; c++) {
                spaces[r][c] = new Button();
                spaces[r][c].addActionListener(this);
                add(spaces[r][c]);
            }
        }

        this.game = game;

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int r = 0; r < spaces.length; r++) {
            for (int c = 0; c < spaces[r].length; c++) {
                if (e.getSource() == spaces[r][c]) {
                    game.click(new Point(r, c), spaces);
                }
            }
        }
    }
}
