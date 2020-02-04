package Data;

import javax.swing.*;


public class Main {

    public static void main(String[] args) {

        Game game = new Game();
        game.addKeyListener(new GameActionListener());
        game.setVisible(true);

        new Timer(10, actionEvent -> { game.updateState(); game.repaint();}).start();
    }
}
