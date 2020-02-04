package Data;

public abstract class MovingThing extends Thing {
    double direction;
    float velocity;
    float angularVelocity;

    MovingThing(int x, int y, double direction, float velocity, float angularVelocity) {
        super(x, y);
        this.direction = direction;
        this.velocity = velocity;
        this.angularVelocity = angularVelocity;
    }

    private void changeDirection(double amount) {
        this.direction = (this.direction + amount) % (2 * Math.PI);
    }

    public void turnLeft() {
        this.changeDirection(-this.angularVelocity);
    }

    public void turnRight() {
        this.changeDirection(this.angularVelocity);
    }

    void step() {
        this.x += this.velocity * Math.cos(this.direction);
        this.y += this.velocity * Math.sin(this.direction);
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }

    public abstract int getRadius();
}
