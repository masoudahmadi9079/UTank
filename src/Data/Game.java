package Data;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game extends JFrame {
    final static int WIDTH = 500, HEIGHT = 500;

    List<Thing> everyThing = new ArrayList<>();
    List<Wall> walls = new ArrayList<>();
    Player player1 = new Player();
    Player player2 = new Player();
    List<Shot> shotsInTheAir = new ArrayList<>();

    Game() {
        this.setSize(Game.WIDTH, Game.HEIGHT);

        Wall leftEdge = new Wall(10, 30, Game.HEIGHT - 43, true);
        this.everyThing.add(leftEdge);
        this.walls.add(leftEdge);

        Wall topEdge = new Wall(10, 30, Game.WIDTH - 23, false);
        this.everyThing.add(topEdge);
        this.walls.add(leftEdge);

        Wall bottomEdge = new Wall(10, 487, Game.WIDTH - 23, false);
        this.everyThing.add(bottomEdge);
        this.walls.add(bottomEdge);

        Wall rightEdge = new Wall(487, 30, Game.HEIGHT - 39, true);
        this.everyThing.add(rightEdge);
        this.everyThing.add(rightEdge);

        this.player1.newRound(false, (int) (Math.random() * Game.WIDTH), (int) (Math.random() * Game.HEIGHT));
        this.player2.newRound(false, (int) (Math.random() * Game.WIDTH), (int) (Math.random() * Game.HEIGHT));

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
                } else {
                    shot.step();
                }
            }
            if (p1Tank.isShot(shot)) {
                this.everyThing.remove(p1Tank);
                player1.newRound(false, (int) (Math.random() * Game.WIDTH), (int) (Math.random() * Game.HEIGHT));
                player2.newRound(true, (int) (Math.random() * Game.WIDTH), (int) (Math.random() * Game.HEIGHT));
            }
            if (p2Tank.isShot(shot)) {
                this.everyThing.remove(p2Tank);
                player1.newRound(true, (int) (Math.random() * Game.WIDTH), (int) (Math.random() * Game.HEIGHT));
                player2.newRound(false, (int) (Math.random() * Game.WIDTH), (int) (Math.random() * Game.HEIGHT));
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
