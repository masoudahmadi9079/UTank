package Data;

import java.awt.*;

public class Menu extends Page {

    Menu(){ }

    void updateState(){
        super.updateState();
        MenuActionListener listener = (MenuActionListener) this.getKeyListeners()[0];
        if (listener.key1) {
            PageHandler.changePage("game");
        }
        if (listener.key2) {
            PageHandler.changePage("settings");
        }
        if (listener.escape) {
            PageHandler.EndGame();
        }
    }
    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.fillRect(50,50, Page.HEIGHT-100, Page.HEIGHT-100);
        graphics.setColor(Color.DARK_GRAY);
        graphics.fillRect(200,110, 200, 80);
        graphics.fillRect(200, 210, 200 ,80);
        graphics.fillRect(200,310, 200, 80);
        graphics.fillRect(200,410, 200, 80);
        graphics.setColor(Color.WHITE);
        graphics.drawString("Press P to PLAY", 240, 150);
        graphics.drawString("Press S for SETTINGS", 240, 250);
        graphics.drawString("Press B for BINDS", 240, 350);
        graphics.drawString("Press ESC to ESCAPE", 240, 450);

    }
}
