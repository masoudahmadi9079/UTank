package Data;

import java.awt.*;

public abstract class Thing {
    int x;
    int y;

    Thing(int x, int y) {
        this.x = x;
        this.y = y;
    }

    abstract void draw(Graphics graphics);
}
