package Data;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game extends Page {
    List<Wall> walls = new ArrayList<>();
    Player player1 = new Player();
    Player player2 = new Player();
    List<Shot> shotsInTheAir = new ArrayList<>();
    Tank p1Tank;
    Tank p2Tank;
    JLabel scores;

    Game() {
        scores = new JLabel("Welcome!");
        this.add(scores, BorderLayout.NORTH);

        // wall generator
        boolean isVertical;
        for (int i = 0; i < Util.MAPS[Util.currentMap].length; i++){
            if (Util.MAPS[Util.currentMap][i][3] == 1)
                isVertical = true;
            else
                isVertical = false;
            addWall( new Wall( Util.MAPS[Util.currentMap][i][0], Util.MAPS[Util.currentMap][i][1], Util.MAPS[Util.currentMap][i][2], isVertical));
        }

        p1Tank = player1.newTank(Color.BLUE);
        p2Tank = player2.newTank(Color.RED);

        this.everyThing.add(p1Tank);
        this.everyThing.add(p2Tank);
    }

    private void updateScore(){
        // todo: change this line and make it's graphic better
        scores.setText("Blue => " + player1.getPoints() + " ---- Red => " + player2.getPoints());
        if (player1.getPoints() >= Util.pointsToWin) {
            JOptionPane.showMessageDialog(this, "Blue won the game");
            PageHandler.changePage("menu");
        }else if(player2.getPoints() >= Util.pointsToWin) {
            JOptionPane.showMessageDialog(this, "Red won the game");
            PageHandler.changePage("menu");
        }
    }

    private void addWall(Wall wall){
        this.everyThing.add(wall);
        this.walls.add(wall);
    }

    private void resetRound(){
        this.everyThing.remove(p1Tank);
        p1Tank = player1.newTank(Color.BLUE);
        this.everyThing.add(p1Tank);
        this.everyThing.remove(p2Tank);
        p2Tank = player2.newTank(Color.RED);
        this.everyThing.add(p2Tank);
        shotsInTheAir = new ArrayList<>();
    }

    void updateState() {
        // shots and walls contacts
        for (Shot shot : this.shotsInTheAir) {
            for (Wall wall : this.walls) {
                if (wall.contacts(shot)) {
                    shot.bounceAgainst(wall);
                }
            }
            shot.step();

            // shots and players contacts
            if (p1Tank.isShot(shot)) {
                player2.addPoint();
                updateScore();
                resetRound();
                JOptionPane.showMessageDialog(this, "Red got this one!");
            }
            if (p2Tank.isShot(shot)) {
                player1.addPoint();
                updateScore();
                resetRound();
                JOptionPane.showMessageDialog(this, "Blue got this one!");
            }
        }

        this.shotsInTheAir.forEach(Shot::growOld);
        this.shotsInTheAir.removeIf(Shot::isDead);

        // score check
        if (player1.getShots() <= 0 && player2.getShots() <= 0){
            JOptionPane.showMessageDialog(this, "That's a Tie!");
            resetRound();
        }

        GameActionListener listener = (GameActionListener) this.getKeyListeners()[0];

        // players move
        if (listener.p1Move) {
            p1Tank.step();
        }
        if (listener.p2Move) {
            p2Tank.step();
        }

        // player and walls contacts
        for (Wall wall : this.walls){
            double dir;
            if (wall.contacts(p1Tank)){
                dir = p1Tank.getDirection();
                if (dir < 0){
                    p1Tank.setDirection(Math.PI + dir);
                }else{
                    p1Tank.setDirection(-Math.PI + dir);
                }
                p1Tank.step();
                p1Tank.setDirection(dir);
            }
            if (wall.contacts(p2Tank)){
                dir = p2Tank.getDirection();
                if (dir < 0){
                    p2Tank.setDirection(Math.PI + dir);
                }else{
                    p2Tank.setDirection(-Math.PI + dir);
                }
                p2Tank.step();
                p2Tank.setDirection(dir);
            }
        }

        // players turning and fire
        if (listener.p1Left) {
            p1Tank.turnLeft();
        }
        if (listener.p1Right) {
            p1Tank.turnRight();
        }
        if (listener.p1Fire) {
            player1.oneLessShot();
            if (player1.getShots() > 0){
                this.shotsInTheAir.add(new Shot(p1Tank.getGunX(), p1Tank.getGunY(), p1Tank.getDirection()));
            }
            listener.p1Fire = false;
        }
        if (listener.p2Left) {
            p2Tank.turnLeft();
        }
        if (listener.p2Right) {
            p2Tank.turnRight();
        }
        if (listener.p2Fire) {
            player2.oneLessShot();
            if (player2.getShots() > 0) {
                this.shotsInTheAir.add(new Shot(p2Tank.getGunX(), p2Tank.getGunY(), p2Tank.getDirection()));
            }
            listener.p2Fire = false;
        }
        if (listener.escape) {
            PageHandler.changePage("menu");
        }
    }

    public void paint(Graphics graphics) {
        super.paint(graphics);
        this.shotsInTheAir.forEach(s -> s.draw(graphics));
        Toolkit.getDefaultToolkit().sync();
    }
}
