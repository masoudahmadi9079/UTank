package Data;

public class Player {
    private Tank tank;
    private int points = 0;

    void respawn(){
        this.tank = new Tank(
                (int) ((Math.random() * (Game.WIDTH - (Game.OFFSET*2))) + Game.OFFSET),
                (int) ((Math.random() * (Game.HEIGHT - (Game.OFFSET*2))) + Game.OFFSET),
                0);
    }

    void addPoint(){
        this.points++;
    }

    Tank getTank() {
        return this.tank;
    }

    public int getPoints() {
        return points;
    }
}
