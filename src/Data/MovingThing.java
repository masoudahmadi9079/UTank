package Data;

public abstract class MovingThing extends Thing {
    double direction;
    float velocity;
    float vX, vY;
    float angularVelocity;

    MovingThing(int x, int y, double direction, float velocity, float angularVelocity) {
        super(x, y);
        this.direction = direction;
        this.velocity = velocity;
        this.angularVelocity = angularVelocity;
        this.calculateVxAndVy();
    }


    void calculateVxAndVy() {
        this.vX = (int) Math.round(this.velocity * Math.cos(this.direction));
        this.vY = (int) Math.round(this.velocity * Math.sin(this.direction));
    }

    private void changeDirection(double amount) {
        this.direction = (this.direction + amount) % (2 * Math.PI);
        this.calculateVxAndVy();
    }

    public void turnLeft() {
        this.changeDirection(-this.angularVelocity);
    }

    public void turnRight() {
        this.changeDirection(this.angularVelocity);
    }

    void step() {
        this.x += this.vX;
        this.y += this.vY;
    }

    void stepBack() {
        this.x -= this.vX;
        this.y -= this.vY;
    }



    void blockedBy(Wall wall) {
        if (wall.isVertical) {
            if ((wall.j < x && vX < 0) || (wall.j > x && vX > 0))
                vX = 0;
        } else {
            if ((wall.j < y && vY < 0) || (wall.j > y && vY > 0))
                vY = 0;
        }
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }

    private double calculateDistance(int x, int y) {
        return (Math.sqrt((this.x - x)*(this.x - x)) + ((this.y - y)*(this.y - y)));
    }

    boolean contacts(Wall wall) {
        int x1 = wall.x;
        int y1 = wall.y;
        int x2 = (wall.isVertical? x1 + Wall.WIDTH : x1 + wall.length);
        int y2 = (wall.isVertical? y1 + wall.length : y1 + Wall.WIDTH);

        if (this.getX() + getRadius() > x1 &&
                this.getX() + getRadius() < x2 &&
                this.getY() + getRadius() > y1 &&
                this.getY() + getRadius() < y2 &&
                calculateDistance(x1, y1) < getRadius() &&
                calculateDistance(x1, y2) < getRadius() &&
                calculateDistance(x2, y1) < getRadius() &&
                calculateDistance(x2, y2) < getRadius()) {
            return true;
        }
        return false;
    }

    public abstract int getRadius();
}
