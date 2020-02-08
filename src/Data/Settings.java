package Data;

import java.awt.*;

public class Settings extends Page {
    private int option = 0;
    private int optionsIndex[] = {0, 0, 0};
    private int[] options[] = {
            {5, 7, 9},
            {10, 15, 20},
            {50, 66, 100} };

    Settings(){
        optionsIndex[0] = Util.findIndex(options[0], Util.bulletsCount);
        optionsIndex[1] = Util.findIndex(options[1], Util.pointsToWin);
        optionsIndex[2] = Util.findIndex(options[2], PageHandler.getTimerDelay());

    }

    void updateState(){
        super.updateState();
        SettingsActionListener listener = (SettingsActionListener) this.getKeyListeners()[0];
        if (listener.escape) {
            Util.bulletsCount = options[0][optionsIndex[0]];
            Util.pointsToWin = options[1][optionsIndex[1]];
            PageHandler.setupTimer(options[2][optionsIndex[2]]);
            PageHandler.changePage("menu");
        }
        if (listener.keyDown && listener.downReleased) {
            listener.downReleased = false;
            option = (option+1) % 3;
        }
        if (listener.keyRight && listener.rightReleased) {
            listener.rightReleased = false;
            optionsIndex[option]++;
            optionsIndex[option] %= 3;
        }
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.fillRect(50,50, Page.HEIGHT-100, Page.HEIGHT-100);
        graphics.setColor(Color.DARK_GRAY);
        graphics.fillRect(100,120, 400, 60);
        graphics.fillRect(100, 200, 400 ,60);
        graphics.fillRect(100,280, 400, 60);
        graphics.setColor(Color.BLACK);
        graphics.fillRect(150,360, 300, 120);
        graphics.setColor(Color.PINK);
        graphics.fillRect(100,option*80 + 120, 400, 60);
        graphics.setColor(Color.WHITE);
        graphics.drawString("Number of bullets in each round: " + options[0][optionsIndex[0]] , 150, 150);
        graphics.drawString("Number of required point to win: " + options[1][optionsIndex[1]] , 150, 230);
        graphics.drawString("Rendering frames per second: " + options[2][optionsIndex[2]] , 150, 310);

        // todo : add instructions
    }
}
