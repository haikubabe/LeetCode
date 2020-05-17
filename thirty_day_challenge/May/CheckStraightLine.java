package thirty_day_challenge.May;

/**
 * #Leetcode - 1232
 */
public class CheckStraightLine
{
    public static boolean checkStraightLine(int[][] coordinates) {
        int[] p0 = coordinates[0];
        int[] p1 = coordinates[1];
        float slope = calculateSlope(p0,p1);
        for (int i=1;i<coordinates.length;i++) {
            int[] point0 = coordinates[0];
            int[] point1 = coordinates[i];
            float s = calculateSlope(point0, point1);
            if (slope != s) {
                return false;
            }
        }
        return true;
    }

    private static float calculateSlope(int[] p1, int[] p2) {
        if (p2[0] - p1[0] == 0) {
            return 0;
        }
        return (float) (p2[1] - p1[1])/(p2[0] - p1[0]);
    }

    public static void main(String[] args)
    {
        int[][] coordinates = {
                {1,1},
                {2,2},
                {3,4},
                {4,5},
                {5,6},
                {7,7}
        };
        System.out.println(checkStraightLine(coordinates));
    }
}
