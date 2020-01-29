package Data;

public class Player {
    private Tank tank;
    private int points = 0;

    void newRound(boolean hasWon, int startX, int startY) {
        if (hasWon) {
            this.points++;
        } else {
            this.tank = new Tank(startX, startY, 0);
        }
    }

    Tank getTank() {
        return this.tank;
    }

    public int getPoints() {
        return points;
    }
}
