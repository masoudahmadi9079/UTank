package Data;

import java.util.Arrays;

public class Util {

    public static int bulletsCount = 5;
    public static int pointsToWin = 10;

    private Util() {}

    public static int findIndex(int arr[], int t)
    {
        int index = Arrays.binarySearch(arr, t);
        return (index < 0) ? -1 : index;
    }
}
