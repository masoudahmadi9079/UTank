package Data;

public class Player {
    private Tank tank;
    private int points = 0;

    // todo: the tanks should not respawn in walls maybe???

    // to handle respawn things
    private void respawn(){
        this.tank = new Tank(
                (int) ((Math.random() * (Page.WIDTH - ((Game.OFFSET + Tank.RADIUS) *2) - 10)) + Game.OFFSET + Tank.RADIUS + 5),
                (int) ((Math.random() * (Page.HEIGHT - ((Game.OFFSET + Tank.RADIUS) *2) - 10)) + Game.OFFSET + Tank.RADIUS + 5),
                0);
    }

    void addPoint(){
        this.points++;
    }

    // add a new tank
    Tank newTank() {
        this.respawn();
        return this.tank;
    }

    public int getPoints() {
        return points;
    }
}
