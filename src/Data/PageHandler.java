package Data;

import javax.swing.*;
import java.awt.event.KeyAdapter;

public class PageHandler {

    private static Page currentPage;
    private static Timer timer;

    private PageHandler(){};

    public static void SetupPageHandler(){
        currentPage = new Menu();
        currentPage.addKeyListener(new MenuActionListener());
        currentPage.setUndecorated(true);
        currentPage.setVisible(true);

        timer = new Timer(10, actionEvent -> { currentPage.updateState(); currentPage.repaint();});;
        timer.start();
    }

    public static void changePage(String name){
        //currentPage.setVisible(false);
        currentPage.dispose();
        switch (name){
            case "menu":
                currentPage = new Menu();
                currentPage.addKeyListener(new MenuActionListener());
                break;
            case "game":
                currentPage = new Game();
                currentPage.addKeyListener(new GameActionListener());
                break;
        }
        currentPage.setUndecorated(true);
        currentPage.setVisible(true);
    }

    public static void EndGame(){
        currentPage.setVisible(false);
        currentPage.dispose();
    }

}
