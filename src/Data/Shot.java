package Data;

import java.awt.*;

public class Shot extends MovingThing{
    private final static int RADIUS = 5;
    private final static int LIFE = 100;

    private int age = Shot.LIFE;

    Shot(int x, int y, double direction) {
        super(x, y, direction, 3 , 0);
    }

    public void draw(Graphics graphics) {
        graphics.fillOval(this.x - Shot.RADIUS, this.y - Shot.RADIUS, Shot.RADIUS * 2, Shot.RADIUS * 2);
    }

    boolean contacts(Thing thing) {
        return calculateDistance(thing) < getRadius();
    }

    void growOld() {
        this.age--;
    }

    boolean isDead() {
        return this.age <= 0;
    }

    void bounceAgainst(Wall wall) { this.direction = ((wall.isVertical? Math.PI : 0) - this.direction); }

    public int getRadius() {
        return RADIUS;
    }
}
