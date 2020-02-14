package Data;

import java.awt.*;

public class Mine extends Thing {
    final static int RADIUS =5;

    Mine(int x, int y) {
        super(x, y);
    }

    @Override
    void draw(Graphics graphics) {
        graphics.setColor(Color.BLUE);
        graphics.fillOval(this.x - Mine.RADIUS, this.y - Mine.RADIUS, Mine.RADIUS * 2, Mine.RADIUS * 2);
        graphics.setColor(Color.BLUE);
    }

}
