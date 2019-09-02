public class MonotonicArray {
    private static boolean isMonotonic(int[] A) {
        boolean increasing=true, decreasing=true;
        for (int i=1;i<A.length;i++) {
            if (A[i-1]>A[i]) {
                increasing=false;
            }
            if (A[i-1]<A[i]) {
                decreasing=false;
            }
        }
        return increasing || decreasing;
    }

    public static void main(String[] args) {
        int[] A = {1,2,2};
        System.out.println(isMonotonic(A));
    }
}
