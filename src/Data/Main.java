package Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Main {

    public static void main(String[] args) {

        Game game = new Game();

        game.setUndecorated(true); // removing title bar and the rest

        game.addKeyListener(new GameActionListener());
        game.setVisible(true);

        new Timer(10, actionEvent -> { game.updateState();game.repaint();}).start();;
    }
}
