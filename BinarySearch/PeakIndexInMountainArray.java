package BinarySearch;

/**
 * Leetcode - #852
 */
public class PeakIndexInMountainArray
{
    private static int binarySearch(int[] A, int low, int high) {
        if (low <= high) {
            int mid = (low+high)/2;
            // if the left and right elements are smaller
            if ((mid > 0 && A[mid-1] < A[mid]) && (mid < A.length-1 && A[mid] > A[mid+1])) {
                return mid;
            }
            // if left sides are bigger
            if (mid > 0 && A[mid] < A[mid-1]) {
                return binarySearch(A, low, mid-1);
            }
            // normal case, if right sides are bigger
            if (mid < A.length-1 && A[mid] < A[mid+1]) {
                return binarySearch(A, mid+1, high);
            }
        }
        return -1;
    }

    public static int peakIndexInMountainArray(int[] A) {
        return binarySearch(A, 0, A.length-1);
    }

    public static void main(String[] args)
    {
        int[] A = {0,2,1,0};
        System.out.println(peakIndexInMountainArray(A));
    }
}
