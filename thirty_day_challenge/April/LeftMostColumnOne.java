package thirty_day_challenge.April;

import java.util.List;

public class LeftMostColumnOne
{

    private static int binarySearch(BinaryMatrix binaryMatrix, int row, int low, int high) {
        if (low <= high) {
            int mid = (low+high)/2;
            int midVal = binaryMatrix.get(row,mid);
            if ((midVal == 1 && (mid-1 >= low && binaryMatrix.get(row,mid-1) < 1)) ||
                (midVal == 1 && mid-1 < low)) {
                return mid;
            }
            if (midVal == 0) {
                return binarySearch(binaryMatrix, row, mid+1, high);
            }
            if (midVal == 1) {
                return binarySearch(binaryMatrix, row, low, mid-1);
            }
        }
        return -1;
    }

    public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int minIndex = Integer.MAX_VALUE;
        List<Integer> dimensions = binaryMatrix.dimensions();
        int n = dimensions.get(0);
        int m = dimensions.get(1);
        for (int r=0;r<n;r++) {
            int index = binarySearch(binaryMatrix, r,0, m-1);
            if ((index >= 0 && index < n) && index < minIndex) {
                minIndex = index;
            }
        }
        if (minIndex == Integer.MAX_VALUE) {
            return -1;
        }
        return minIndex;
    }

    public static void main(String[] args)
    {
        BinaryMatrix binaryMatrix = new BinaryMatrix(5, 5);
        binaryMatrix.arr = new int[][]{
                                {1,1,1,1,1},
                                {0,0,0,1,1},
                                {0,0,1,1,1},
                                {0,0,0,0,1},
                                {0,0,0,0,0}
                                };
        System.out.println(leftMostColumnWithOne(binaryMatrix));
    }
}
