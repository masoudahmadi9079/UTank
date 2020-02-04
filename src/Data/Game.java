package Data;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Game extends JFrame {
    public final static int WIDTH = 500, HEIGHT = 500;

    List<Thing> everyThing = new ArrayList<>();
    List<Wall> walls = new ArrayList<>();
    Player player1 = new Player();
    Player player2 = new Player();
    List<Shot> shotsInTheAir = new ArrayList<>();

    Game() {
        this.setSize(Game.WIDTH, Game.HEIGHT);

        Map map = new Map(Map.mapLoader.x1);
        this.walls.addAll(map.walls);
        this.everyThing.addAll(map.walls);

        this.player1.newRound(false, (int) (Math.random() * (Game.WIDTH - 60) + 50), (int) (Math.random() * (Game.HEIGHT - 60) + 50));
        this.player2.newRound(false, (int) (Math.random() * (Game.WIDTH - 60) + 50), (int) (Math.random() * (Game.HEIGHT - 60) + 50));

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
                shot.step();
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

        if (listener.p1Move) {
            for (Wall wall : walls) {
                if (p1Tank.contacts(wall)) {
                    System.out.println("ffffffffff");
                    p1Tank.blockedBy(wall);
                }
            }
            p1Tank.step();
            if (contacts(p1Tank, p2Tank)) {
                p1Tank.stepBack();
                //p2Tank.stepBack();
            }
        }

        if (listener.p1Left) {
            p1Tank.turnLeft();
        }
        if (listener.p1Right) {
            p1Tank.turnRight();
        }
        if (listener.p1Fire) {
            Shot shot = p1Tank.shot();
            shotsInTheAir.add(shot);
            everyThing.add(shot);
            listener.p1Fire = false;
        }

        if (listener.p2Move) {
            for (Wall wall : walls) {
               // System.out.println(wall.contacts(p2Tank));
                if (wall.contacts(p2Tank)) {
                    p2Tank.blockedBy(wall);
                    break;
                }
            }
            p2Tank.step();
            if (contacts(p1Tank, p2Tank)) {
                //p1Tank.stepBack();
                p2Tank.stepBack();
            }
        }

        if (listener.p2Left) {
            p2Tank.turnLeft();
        }
        if (listener.p2Right) {
            p2Tank.turnRight();
        }

        if (listener.p2Fire) {
            Shot shot = p2Tank.shot();
            shotsInTheAir.add(shot);
            everyThing.add(shot);
            listener.p2Fire = false;
        }
        if (listener.escape) {
            setVisible(false);
            dispose();
        }

        //System.out.println(contacts(p1Tank, p2Tank));

    }
    boolean contacts(MovingThing moving1, MovingThing moving2) {
        int delta_x = moving1.x - moving2.x;
        int delta_y = moving1.y - moving2.y;
        double distance = Math.sqrt(delta_x * delta_x + delta_y * delta_y);
        return distance < moving1.getRadius() + moving2.getRadius();
    }

        public void paint (Graphics graphics){
            super.paint(graphics);
            this.everyThing.forEach(thing -> thing.draw(graphics));
            // this.shotsInTheAir.forEach(thing -> thing.draw(graphics));
            Toolkit.getDefaultToolkit().sync();
        }

    }
