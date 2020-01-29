package Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class Main {

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(500, 500);
        jFrame.setVisible(true);


        Graphics graphics = jFrame.getGraphics();

        jFrame.addMouseListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent e)
        });
    }
}
