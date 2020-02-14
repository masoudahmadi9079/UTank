package Data;

import java.awt.*;

public class Wall extends Thing {
    private final static int WIDTH = 4;

    private int size;
    boolean isVertical;

    Wall(int x, int y, int size, boolean isVertical) {
        super(x,y);
        this.isVertical = isVertical;
        if (isVertical) {
            this.size = size;
        } else {
            this.size = size;
        }
    }

    public void draw(Graphics graphics) {
        int width = (this.isVertical)? Wall.WIDTH : size;
        int height = (this.isVertical)? size : Wall.WIDTH;
        graphics.fillRect(this.getX(), this.getY(), width, height);
    }

    private int getX() {
        return this.x;
    }

    private int getY() {
        return this.y;
    }

    boolean contacts(MovingThing moving) {
        // rewrite the contact system from scratch

        int radius = moving.getRadius();
        if (isVertical){
            return (moving.getX() + radius >= this.x && moving.getX() - radius <= this.x + Wall.WIDTH) &&
                    (moving.getY() + radius >= this.y && moving.getY() - radius <= this.y + size);
        }else{
            return (moving.getX() + radius >= this.x && moving.getX() - radius <= this.x + size) &&
                    (moving.getY() + radius >= this.y && moving.getY() - radius <= this.y + Wall.WIDTH);
        }
    }
}
