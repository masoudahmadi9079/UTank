package Data;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game extends JFrame {
    final static int WIDTH = 500, HEIGHT = 500;
    final static int OFFSET = 20;

    List<Thing> everyThing = new ArrayList<>();
    List<Wall> walls = new ArrayList<>();
    Player player1 = new Player();
    Player player2 = new Player();
    List<Shot> shotsInTheAir = new ArrayList<>();

    Game() {
        this.setSize(Game.WIDTH, Game.HEIGHT);

        Wall leftEdge = new Wall(Game.OFFSET, Game.OFFSET, Game.HEIGHT - (Game.OFFSET*2), true);
        this.everyThing.add(leftEdge);
        this.walls.add(leftEdge);

        Wall topEdge = new Wall(Game.OFFSET, Game.OFFSET, Game.WIDTH - (Game.OFFSET*2), false);
        this.everyThing.add(topEdge);
        this.walls.add(topEdge);

        Wall bottomEdge = new Wall(Game.OFFSET, Game.HEIGHT - Game.OFFSET, Game.WIDTH - (Game.OFFSET*2), false);
        this.everyThing.add(bottomEdge);
        this.walls.add(bottomEdge);

        Wall rightEdge = new Wall(Game.WIDTH - Game.OFFSET, Game.OFFSET, Game.HEIGHT - (Game.OFFSET*2), true);
        this.everyThing.add(rightEdge);
        this.walls.add(rightEdge);

        this.player1.respawn();
        this.player2.respawn();

        this.everyThing.add(player1.getTank());
        this.everyThing.add(player2.getTank());
    }

    void updateState() {
        Tank p1Tank = this.player1.getTank();
        Tank p2Tank = this.player2.getTank();

        for (Shot shot : this.shotsInTheAir) {
            for (Wall wall : this.walls) {
                if (wall.contacts(shot)) {
                    shot.bounceAgainst(wall);
                }
            }
            shot.step();
            if (p1Tank.isShot(shot)) {
                this.everyThing.remove(p1Tank);
                player1.respawn();
                player2.addPoint();
            }
            if (p2Tank.isShot(shot)) {
                this.everyThing.remove(p2Tank);
                player1.addPoint();
                player2.respawn();
            }
        }

        this.shotsInTheAir.forEach(Shot::growOld);
        this.shotsInTheAir.removeIf(Shot::isDead);

        GameActionListener listener = (GameActionListener) this.getKeyListeners()[0];

        if (listener.p1Move && this.walls.stream().noneMatch(wall -> wall.contacts(p1Tank))) {
            p1Tank.step();
        }
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
        if (listener.p2Move && this.walls.stream().noneMatch(wall -> wall.contacts(p2Tank))) {
            p2Tank.step();
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
            setVisible(false);
            dispose();
        }
    }
    public void paint(Graphics graphics) {
        super.paint(graphics);
        this.everyThing.forEach(thing -> thing.draw(graphics));
        this.shotsInTheAir.forEach(s -> s.draw(graphics));
        Toolkit.getDefaultToolkit().sync();
    }

}
