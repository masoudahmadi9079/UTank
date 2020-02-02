package Data;

import java.awt.*;

public class Tank extends MovingThing {
    private final static int RADIUS = 25;
    private final static int GUN_LENGTH = 30;

    Tank(int x, int y, double direction) {
        super(x, y, direction, 2f, 0.06f);
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

    boolean isShot(Shot shot) {
        return (shot.x < this.x + RADIUS && shot.x > this.x - RADIUS) && (shot.y < this.y + RADIUS && shot.y > this.y - RADIUS);
    }

    public int getRadius() {
        return RADIUS;
    }

    double getDirection() {
        return this.direction;
    }

    int getGunX() {
        return (int) Math.round(this.x + (Tank.GUN_LENGTH * Math.cos(this.direction)));
    }

    int getGunY() {
        return (int) Math.round(this.y + (Tank.GUN_LENGTH * Math.sin(this.direction)));
    }
}
