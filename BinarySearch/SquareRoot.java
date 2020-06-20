package BinarySearch;

public class SquareRoot
{
    private static int binarySearch(int start, int end, int target) {
        int mid = start + (end-start)/2;
        if (Math.floor(Math.abs((mid * mid) - target)) == 0) {
            return mid;
        }
        if (mid * mid > target) {
            return binarySearch(start, mid-1, target);
        }
        return binarySearch(mid+1, end, target);
    }

    public static float mySqrt(int x) {
        return binarySearch(1,x,x);
    }

    public static void main(String[] args)
    {
        int x = 8;
        System.out.println(mySqrt(x));
    }
}
