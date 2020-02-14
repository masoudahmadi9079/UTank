package Data;

import javax.swing.*;

public class PageHandler {

    private static Page currentPage;
    private static Timer timer;

    private PageHandler(){}

    public static void SetupPageHandler(){
        currentPage = new Menu();
        currentPage.addKeyListener(new MenuActionListener());
        currentPage.setUndecorated(true);
        currentPage.setVisible(true);

        setupTimer(50);
    }

    public static void setupTimer(int fps){
        if (timer != null){
            timer.stop();
        }
        timer = new Timer((int) (1000 / fps), actionEvent -> { currentPage.updateState(); currentPage.repaint();});;
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
            case "settings":
                currentPage = new Settings();
                currentPage.addKeyListener(new MenuActionListener());
                break;
            case "binds":
                currentPage = new Binds();
                currentPage.addKeyListener(new BindsActionListener());
                break;
            case "maps":
                currentPage = new MapSelection();
                currentPage.addKeyListener(new MenuActionListener());
        }
        currentPage.setUndecorated(true);
        currentPage.setVisible(true);
    }

    public static int getTimerDelay(){
        return (int) (1000 / PageHandler.timer.getDelay());
    }

    public static void EndGame(){
        currentPage.setVisible(false);
        currentPage.dispose();
    }

}
