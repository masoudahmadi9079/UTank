package Data;

import java.awt.*;

public class Player {
    private Tank tank;
    private int points = 0;
    private int shots = 0;

    // to handle respawn things
    private void respawn(Color color){
        this.tank = new Tank(
                (int) ((Math.random() * (Page.WIDTH - ((50 + Tank.RADIUS) *2) - 10)) + 50 + Tank.RADIUS + 5),
                (int) ((Math.random() * (Page.HEIGHT - ((50 + Tank.RADIUS) *2) - 10)) + 50 + Tank.RADIUS + 5),
                0, color);
    }

    public void addPoint(){
        this.points++;
    }
    public void oneLessShot(){
        this.shots--;
    }

    public int getShots(){
        return this.shots;
    }

    // add a new tank
    public Tank newTank(Color color) {
        this.shots = Util.bulletsCount;
        this.respawn(color);
        return this.tank;
    }

    public int getPoints() {
        return points;
    }
}
