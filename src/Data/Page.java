package Data;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Page extends JFrame {
    final static int WIDTH = 600, HEIGHT = 600;
    List<Thing> everyThing = new ArrayList<>();

    Page(){
        this.setSize(Game.WIDTH, Game.HEIGHT);
    }

    void updateState(){

    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
        this.everyThing.forEach(thing -> thing.draw(graphics));
    }
}
