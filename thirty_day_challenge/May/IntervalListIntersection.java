package thirty_day_challenge.May;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode - #986
 */
public class IntervalListIntersection
{
    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList<>();
        int i=0,j=0;
        while (i<A.length && j<B.length) {
            int ALow = A[i][0];
            int AHigh = A[i][1];
            int BLow = B[j][0];
            int BHigh = B[j][1];
            // start point of the intersection
            int start = Math.max(ALow, BLow);
            // end point of the intersection
            int end = Math.min(AHigh, BHigh);
            if (start <= end) {
                res.add(new int[]{start,end});
            }
            // remove the end point of the intersection
            if (AHigh < BHigh) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args)
    {
        int[][] A = {
                {0,2},
                {5,10},
                {13,23},
                {24,25}
        };
        int[][] B = {
                {1,5},
                {8,12},
                {15,24},
                {25,26}
        };
        int[][] res = intervalIntersection(A,B);
        for (int i=0;i<res.length;i++) {
            for (int j=0;j<=1;j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
