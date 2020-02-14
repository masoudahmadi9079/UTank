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
            { Page.WIDTH / 5, Page.HEIGHT * 3 / 10, Page.WIDTH * 3 / 5, 0},
            { Page.HEIGHT * 4 / 5, Page.WIDTH * 3 / 10, Page.HEIGHT / 2, 1},
            { Page.WIDTH * 3 / 5, Page.HEIGHT / 5, (Page.WIDTH * 2 / 5) - 20, 0},
            { Page.WIDTH / 2, (Page.HEIGHT / 10) + 20, (Page.HEIGHT / 5) - 20, 1},
            { Page.WIDTH / 2, Page.HEIGHT / 2, Page.HEIGHT / 3, 1},
            { Page.WIDTH / 5, Page.HEIGHT * 3 / 10, Page.HEIGHT * 2 / 3, 1},
            { Page.WIDTH * 2 / 5, 20, Page.HEIGHT / 10, 1},
            { 20, Page.HEIGHT / 5, Page.WIDTH / 5, 0},
    },{
            { 20, 20, Page.HEIGHT - 40, 1},
            { 20, 20, Page.WIDTH - 40 , 0},
            { 20, Page.HEIGHT - 20, Page.WIDTH - 40, 0},
            { Page.WIDTH - 20, 20, Page.HEIGHT - 40, 1},
            { Page.WIDTH / 3, Page.HEIGHT / 5, Page.HEIGHT * 2 / 5, 1},
            { Page.WIDTH / 3, Page.HEIGHT * 2 / 5, Page.WIDTH / 6 + 4, 0},
            { Page.WIDTH * 2 / 3, Page.HEIGHT * 2 / 5, Page.HEIGHT / 3, 1},
            { 20, Page.HEIGHT * 3 / 5, Page.WIDTH / 2, 0},
            { Page.WIDTH / 2, Page.HEIGHT * 3 / 10, Page.WIDTH / 3, 0},
            { Page.WIDTH * 3 / 4, Page.HEIGHT / 2, (Page.WIDTH / 4) - 20, 0},
            { Page.WIDTH / 2, Page.HEIGHT / 5 , Page.HEIGHT / 5, 1},
            { Page.WIDTH * 5 / 12, 20, Page.HEIGHT / 4, 1},
    },{
            { 20, 20, Page.HEIGHT - 40, 1},
            { 20, 20, Page.WIDTH - 40 , 0},
            { 20, Page.HEIGHT - 20, Page.WIDTH - 40, 0},
            { Page.WIDTH - 20, 20, Page.HEIGHT - 40, 1},
            { Page.WIDTH / 2, Page.HEIGHT / 5 , Page.HEIGHT * 3 / 5, 1},
            { Page.WIDTH / 6, Page.HEIGHT * 7 / 10, Page.WIDTH / 3, 0},
            { Page.WIDTH / 3, Page.HEIGHT / 2, Page.WIDTH / 6, 0},
            { Page.WIDTH / 8, Page.HEIGHT / 3, Page.WIDTH * 3 / 8, 0},
            { Page.WIDTH / 2, Page.HEIGHT / 5, Page.WIDTH / 4, 0},
            { Page.WIDTH / 2, Page.HEIGHT / 3, Page.WIDTH / 3, 0},
            { Page.WIDTH / 2, Page.HEIGHT * 3 / 5, Page.WIDTH / 3, 0},
            { Page.WIDTH * 3 / 4, Page.HEIGHT * 3 / 5, Page.HEIGHT / 4, 1},
    }};

    public static int currentMap = 0;

    private Util() {}

    public static int findIndex(int arr[], int t)
    {
        int index = Arrays.binarySearch(arr, t);
        return (index < 0) ? -1 : index;
    }
}
