package Data;

import java.awt.*;

public class Tank extends MovingThing {
    final static int RADIUS = 25;
    final static int GUN_LENGTH = 30;

    Tank(int x, int y, double direction) {
        super(x, y, direction, 2f, 0.6f);
    }

    public void draw(Graphics graphics) {
        graphics.drawOval(
                this.x - Tank.RADIUS,
                this.y - Tank.RADIUS,
                Tank.RADIUS * 2,
                Tank.RADIUS * 2
        );
        graphics.drawLine(this.x, this.y, this.getGunX(), this.getGunY());
    }

    public boolean isShot(Shot shot) {
        return (shot.x < this.x + RADIUS && shot.x > this.x - RADIUS) || (shot.y < this.y + RADIUS && shot.y > this.y - RADIUS);
    }

    public int getRadius() {
        return RADIUS;
    }

    public double getDirection() {
        return this.direction;
    }

    int getGunX() {
        return (int) Math.round(this.x + (Tank.GUN_LENGTH * Math.sin(this.direction)));
    }

    int getGunY() {
        return (int) Math.round(this.y + (Tank.GUN_LENGTH * Math.sin(this.direction)));
    }
}
