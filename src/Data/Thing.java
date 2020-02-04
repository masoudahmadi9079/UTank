package Data;

import java.awt.*;

abstract class Thing {
    int x;
    int y;

    Thing(int x, int y) {
        this.x = x;
        this.y = y;
    }

    double calculateDistance(Thing thing) {
        return (Math.sqrt((this.x - thing.x)*(this.x - thing.x)) + ((this.y - thing.y)*(this.y - thing.y)));
    }


    abstract void draw(Graphics graphics);
}
