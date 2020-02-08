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

    private Util() {}

    public static int findIndex(int arr[], int t)
    {
        int index = Arrays.binarySearch(arr, t);
        return (index < 0) ? -1 : index;
    }
}
