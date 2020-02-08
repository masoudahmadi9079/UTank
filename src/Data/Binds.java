package Data;

import java.awt.*;

public class Binds extends Page {
    private int option = 0;
    private boolean bindSelectMode = false;

    Binds(){}

    void updateState(){
        BindsActionListener listener = (BindsActionListener) this.getKeyListeners()[0];
        if (!bindSelectMode){
            if (listener.escape) {
                PageHandler.changePage("menu");
            }
            if (listener.keyDown && listener.downReleased) {
                listener.downReleased = false;
                option = (option+1) % 9;
            }
            if (listener.keyUp && listener.upReleased) {
                listener.upReleased = false;
                option--;
                if (option == -1)
                    option = 8;
            }
            if (listener.keyEnter && listener.enterReleased) {
                listener.enterReleased = false;
                if (option != 8){
                    listener.keyCode = -1;
                    bindSelectMode = true;
                }else{
                    Util.currentBinds = Util.BINDS.clone();
                }
            }
        }else{
            if (listener.keyCode != -1){
                Util.currentBinds[option] = listener.keyCode;
                bindSelectMode = false;
                listener.enterReleased = false;
            }
        }
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.fillRect(50,50, Page.HEIGHT-100, Page.HEIGHT-100);
        graphics.setColor(Color.DARK_GRAY);
        graphics.fillRect(90, 90, 200 ,70);
        graphics.fillRect(90, 180, 200 ,70);
        graphics.fillRect(90, 270, 200 ,70);
        graphics.fillRect(90, 360, 200 ,70);
        graphics.fillRect(310, 90, 200 ,70);
        graphics.fillRect(310, 180, 200 ,70);
        graphics.fillRect(310, 270, 200 ,70);
        graphics.fillRect(310, 360, 200 ,70);
        graphics.fillRect(200, 450, 200 ,70);
        // bind select mode  marker
        if (bindSelectMode){
            graphics.setColor(Color.BLACK);
        }else {
            graphics.setColor(Color.WHITE);
        }
        // option marker
        if (option == 8){
            graphics.fillRect(190,475, 20, 20);
        }else if (option < 4){
            graphics.fillRect(80,option*90 + 115, 20, 20);
        }else{
            graphics.fillRect(300,(option-4)*90 + 115, 20, 20);
        }
        // texts to render
        graphics.setColor(Color.WHITE);
        graphics.drawString("Player1 turn left: " + Util.currentBinds[0], 120, 130);
        graphics.drawString("Player1 turn right: " + Util.currentBinds[1], 120, 220);
        graphics.drawString("Player1 move: " + Util.currentBinds[2], 120, 310);
        graphics.drawString("Player1 fire: " + Util.currentBinds[3], 120, 400);
        graphics.drawString("Player2 turn left: " + Util.currentBinds[4], 340, 130);
        graphics.drawString("Player2 turn right: " + Util.currentBinds[5], 340, 220);
        graphics.drawString("Player2 move: " + Util.currentBinds[6], 340, 310);
        graphics.drawString("Player2 fire: " + Util.currentBinds[7], 340, 400);
        graphics.drawString("RESET EVERYTHING", 240, 490);
    }
}
