package Data;

import java.awt.*;

public class Menu extends Page {
    private int option = 0;

    Menu(){ }

    void updateState(){
        MenuActionListener listener = (MenuActionListener) this.getKeyListeners()[0];
        if (listener.escape) {
            PageHandler.EndGame();
        }
        if (listener.keyDown && listener.downReleased) {
            listener.downReleased = false;
            option = (option+1) % 3;
        }
        if (listener.keyEnter && listener.enterReleased) {
            listener.enterReleased = false;
            switch (option){
                case 0:
                    PageHandler.changePage("game");
                    break;
                case 1:
                    PageHandler.changePage("settings");
                    break;
                case 2:
                    PageHandler.changePage("binds");
                    break;
            }
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
        graphics.drawString("TANKS SHOWDOWN (MULTI PLAYER)", 190, 140);
        graphics.drawString("PLAY THE GAME", 240, 250);
        graphics.drawString("GAME SETTINGS", 240, 350);
        graphics.drawString("KEYBOARD BINDS", 240, 450);
    }
}
