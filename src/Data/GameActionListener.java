package Data;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameActionListener extends KeyAdapter {
    boolean p1Move, p1Left, p1Right, p1Fire,
            p2Move, p2Left, p2Right, p2Fire,
            escape;

    public void keyPressed(KeyEvent event) {
        if (event.getKeyCode() == Util.currentBinds[0]) {
            this.p1Left = true;
        }else if(event.getKeyCode() == Util.currentBinds[1]) {
            this.p1Right = true;
        }else if(event.getKeyCode() == Util.currentBinds[2]) {
            this.p1Move = true;
        }else if(event.getKeyCode() == Util.currentBinds[3]) {
            this.p1Fire = true;
        }else if(event.getKeyCode() == Util.currentBinds[4]) {
            this.p2Left = true;
        }else if(event.getKeyCode() == Util.currentBinds[5]) {
            this.p2Right = true;
        }else if(event.getKeyCode() == Util.currentBinds[6]) {
            this.p2Move = true;
        }else if(event.getKeyCode() == Util.currentBinds[7]) {
            this.p2Fire = true;
        }else if(event.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.escape = true;
        }
        event.consume();
    }

    public void keyReleased(KeyEvent event) {
        if (event.getKeyCode() == Util.currentBinds[0]) {
            this.p1Left = false;
        }else if(event.getKeyCode() == Util.currentBinds[1]) {
            this.p1Right = false;
        }else if(event.getKeyCode() == Util.currentBinds[2]) {
            this.p1Move = false;
        }else if(event.getKeyCode() == Util.currentBinds[3]) {
            this.p1Fire = false;
        }else if(event.getKeyCode() == Util.currentBinds[4]) {
            this.p2Left = false;
        }else if(event.getKeyCode() == Util.currentBinds[5]) {
            this.p2Right = false;
        }else if(event.getKeyCode() == Util.currentBinds[6]) {
            this.p2Move = false;
        }else if(event.getKeyCode() == Util.currentBinds[7]) {
            this.p2Fire = false;
        }else if(event.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.escape = false;
        }
        event.consume();
    }
}
