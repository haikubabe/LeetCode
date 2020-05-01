package thirty_day_challenge.April;

import java.util.ArrayList;
import java.util.List;

public class BinaryMatrix
{

    public int[][] arr;

    public BinaryMatrix(int n, int m) {
        arr = new int[n][m];
    }

    public int get(int x, int y)
    {
        if ((x >= 0 && x < arr.length) && (y >= 0 && y < arr[0].length)) {
            return arr[x][y];
        }
        return -1;
    }

    public List<Integer> dimensions()
    {
        List<Integer> dim = new ArrayList<>();
        dim.add(arr.length);
        dim.add(arr[0].length);
        return dim;
    }
}
