package Data;

import java.awt.*;

public class Wall extends Thing {
    final static int WIDTH = 2;

    private int i1, i2;
    int j;
    int length;
    boolean isVertical;

    public Wall(int x, int y, int length, boolean isVertical) {
        super(x,y);
        this.isVertical = isVertical;
        this.length = length;
        if (isVertical) {
            this.i1 = y;
            this.i2 = y + length;
            this.j = x;
        } else {
            this.i1 = x;
            this.i2 = x + length;
            this.j = y;
        }
    }

    public void draw(Graphics graphics) {
        int width = (this.isVertical)? Wall.WIDTH : this.i2 - this.i1;
        int height = (this.isVertical)? this.i2 - this.i1 : Wall.WIDTH;
        graphics.fillRect(this.getX(), this.getY(), width, height);
    }

    private int getX() {
        return this.x;
    }

    private int getY() {
        return this.y;
    }



    boolean contacts(MovingThing moving) {
        int mI = (this.isVertical)? moving.getY() : moving.getX();
        int mJ = (this.isVertical)? moving.getX() : moving.getY();

        int start = Math.min(this.i1, this.i2);
        int end = Math.max(this.i1, this.i2);

        int contactJ = mJ + ((this.j <= mJ)? -1 : 1) * moving.getRadius();

        return (start <= mI + moving.getRadius() &&
                mI - moving.getRadius() <= end &&
                this.j - Wall.WIDTH <= contactJ &&
                contactJ <= this.j + Wall.WIDTH
        );

    }
}
