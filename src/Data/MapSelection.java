package Data;

import java.awt.*;

public class MapSelection extends Page {
    private int option = 0;

    MapSelection() {
    }

    void updateState() {
        MenuActionListener listener = (MenuActionListener) this.getKeyListeners()[0];
        if (listener.escape) {
            PageHandler.changePage("menu");
        }
        if (listener.keyDown && listener.downReleased) {
            listener.downReleased = false;
            option = (option + 1) % 3;
        }
        if (listener.keyUp && listener.upReleased) {
            listener.upReleased = false;
            option--;
            if (option == -1)
                option = 2;
        }
        if (listener.keyEnter && listener.enterReleased) {
            listener.enterReleased = false;
            Util.currentMap = option;
            PageHandler.changePage("game");
        }
    }
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.fillRect(50,50, Page.HEIGHT-100, Page.HEIGHT-100);
        graphics.setColor(Color.BLACK);
        graphics.fillRect(150,90, 300, 100);
        graphics.setColor(Color.DARK_GRAY);
        graphics.fillRect(200, 210, 200 ,80);
        graphics.fillRect(200,310, 200, 80);
        graphics.fillRect(200,410, 200, 80);
        graphics.setColor(Color.WHITE);
        graphics.fillRect(180,option*100 + 230, 40, 40);
        graphics.drawString("Choose a map please:", 190, 140);
        graphics.drawString("DOWNHILL RIVER", 240, 250);
        graphics.drawString("SKI MOUNTAIN", 240, 350);
        graphics.drawString("CROSSFIRE", 240, 450);
    }
}
