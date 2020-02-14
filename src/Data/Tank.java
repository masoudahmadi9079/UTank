package Data;

import java.awt.*;

public class Tank extends MovingThing {
    final static int RADIUS = 20;
    private final static int GUN_LENGTH = 25;
    private Color color;

    //private int shots;

    Tank(int x, int y, double direction, Color color) {
        super(x, y, direction, 3f, 0.08f);
        this.color = color;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(this.color);
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

    void setDirection(double dir) { this.direction = dir; }

    int getGunX() {
        return (int) Math.round(this.x + (Tank.GUN_LENGTH * Math.cos(this.direction)));
    }

    int getGunY() {
        return (int) Math.round(this.y + (Tank.GUN_LENGTH * Math.sin(this.direction)));
    }

    boolean isMine(Mine mine) {
        return (mine.x < this.x + RADIUS && mine.x > this.x - RADIUS) && (mine.y < this.y + RADIUS && mine.y > this.y - RADIUS);
    }
}