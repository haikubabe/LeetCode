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

    private static int binarySearch(int low, int high) {
        int mid = low + (high-low)/2;
        boolean isMidBad = isBadVersion(mid);
        if(low == mid && isMidBad) {
            return low;
        }
        if (isMidBad) {
            return binarySearch(low,mid);
        }
        return binarySearch(mid+1,high);
    }
    
    public static void main(String[] args)
    {
        int n = 5;
        isBadVersion(4);
        System.out.println(firstBadVersion(n));
    }
}
