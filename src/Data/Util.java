package Data;

import java.awt.event.KeyEvent;
import java.util.Arrays;

public class Util {

    public static int bulletsCount = 5;
    public static int pointsToWin = 10;
    public final static int BINDS[] = {
            KeyEvent.VK_LEFT,
            KeyEvent.VK_RIGHT,
            KeyEvent.VK_UP,
            KeyEvent.VK_ENTER,
            KeyEvent.VK_A,
            KeyEvent.VK_D,
            KeyEvent.VK_W,
            KeyEvent.VK_SPACE,
    };
    public static int[] currentBinds = BINDS.clone();

    public final static int[][][] MAPS = {{
            { 20, 20, Page.HEIGHT - 40, 1},
            { 20, 20, Page.WIDTH - 40 , 0},
            { 20, Page.HEIGHT - 20, Page.WIDTH - 40, 0},
            { Page.WIDTH - 20, 20, Page.HEIGHT - 40, 1},
            { Page.WIDTH / 2, Page.HEIGHT/5 , Page.HEIGHT/5, 1},
            { Page.WIDTH / 2, Page.HEIGHT/5*3 , Page.HEIGHT/5, 1},
    },{
            { 20, 20, Page.HEIGHT - 40, 1},
            { 20, 20, Page.WIDTH - 40 , 0},
            { 20, Page.HEIGHT - 20, Page.WIDTH - 40, 0},
            { Page.WIDTH - 20, 20, Page.HEIGHT - 40, 1},
            { Page.WIDTH / 2, Page.HEIGHT/5 , Page.HEIGHT/5, 1},
    },{
            { 20, 20, Page.HEIGHT - 40, 1},
            { 20, 20, Page.WIDTH - 40 , 0},
            { 20, Page.HEIGHT - 20, Page.WIDTH - 40, 0},
            { Page.WIDTH - 20, 20, Page.HEIGHT - 40, 1},
            { Page.WIDTH / 2, Page.HEIGHT/5*3 , Page.HEIGHT/5, 1},
    }};

    public static int currentMap = 0;

    private Util() {}

    public static int findIndex(int arr[], int t)
    {
        int index = Arrays.binarySearch(arr, t);
        return (index < 0) ? -1 : index;
    }
}
