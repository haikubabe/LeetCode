package thirty_day_challenge.May;

public class FirstBad
{
    private static final int VERSION = 4;

    public static boolean isBadVersion(int version) {
        return VERSION == version;
    }

    public static int firstBadVersion(int n) {
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right-left)/2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return left;
    }

    public static void main(String[] args)
    {
        int n = 5;
        isBadVersion(4);
        System.out.println(firstBadVersion(n));
    }
}
