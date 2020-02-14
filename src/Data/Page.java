package Data;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Page extends JFrame {
    final static int WIDTH = 600, HEIGHT = 600;
    // added by Mahyar Bahram: baraye inke betavan hamzaman az in list object pak kard va hamzaman list object ha baraye rasm farakhani shavad be jaye list az concurrentLInkedQueue estefade shode ast
    ConcurrentLinkedQueue<Thing> everyThing = new ConcurrentLinkedQueue<>();

    Page(){
        this.setSize(Page.WIDTH, Page.HEIGHT);
    }

    void updateState(){

    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
        this.everyThing.forEach(thing -> thing.draw(graphics));
    }
}
