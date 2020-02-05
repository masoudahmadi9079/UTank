package Data;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game extends Page {
    final static int OFFSET = 20;

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

        Wall leftEdge = new Wall(Game.OFFSET, Game.OFFSET, Page.HEIGHT - (Game.OFFSET*2), true);
        Wall topEdge = new Wall(Game.OFFSET, Game.OFFSET, Page.WIDTH - (Game.OFFSET*2), false);
        Wall bottomEdge = new Wall(Game.OFFSET, Page.HEIGHT - Game.OFFSET, Page.WIDTH - (Game.OFFSET*2), false);
        Wall rightEdge = new Wall(Page.WIDTH - Game.OFFSET, Game.OFFSET, Page.HEIGHT - (Game.OFFSET*2), true);
        Wall centerTop = new Wall(Page.WIDTH / 2, Page.HEIGHT/5 , Page.HEIGHT/5, true);
        Wall centerBottom = new Wall(Page.WIDTH / 2, Page.HEIGHT/5*3 , Page.HEIGHT/5, true);
        addWall(leftEdge);
        addWall(topEdge);
        addWall(bottomEdge);
        addWall(rightEdge);
        addWall(centerTop);
        addWall(centerBottom);

        p1Tank = player1.newTank();
        p2Tank = player2.newTank();

        this.everyThing.add(p1Tank);
        this.everyThing.add(p2Tank);
    }

    private void updateScore(){
        scores.setText("Player1 => " + player1.getPoints() + " *** Player2 => " + player2.getPoints());
    }

    private void addWall(Wall wall){
        this.everyThing.add(wall);
        this.walls.add(wall);
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
                this.everyThing.remove(p1Tank);
                p1Tank = player1.newTank();
                this.everyThing.add(p1Tank);
                updateScore();
            }
            if (p2Tank.isShot(shot)) {
                player1.addPoint();
                this.everyThing.remove(p2Tank);
                p2Tank = player2.newTank();
                this.everyThing.add(p2Tank);
                updateScore();
            }
        }

        this.shotsInTheAir.forEach(Shot::growOld);
        this.shotsInTheAir.removeIf(Shot::isDead);

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
            this.shotsInTheAir.add(new Shot(p1Tank.getGunX(), p1Tank.getGunY(), p1Tank.getDirection()));
            listener.p1Fire = false;
            System.err.println(p1Tank.getDirection());
        }
        if (listener.p2Left) {
            p2Tank.turnLeft();
        }
        if (listener.p2Right) {
            p2Tank.turnRight();
        }
        if (listener.p2Fire) {
            this.shotsInTheAir.add(new Shot(p2Tank.getGunX(), p2Tank.getGunY(), p2Tank.getDirection()));
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
