public class NRepeatedElements {
    private static int repeatedNTimes(int[] A) {
        for (int i=2;i<A.length;i++) {
            if (A[i] == A[i-1] || A[i] == A[i-2]) {
                return A[i];
            }
        }
        return A[0];
    }

    public static void main(String[] args) {
        int[] A = {5,1,5,2,5,3,5,4};
        System.out.println(repeatedNTimes(A));
    }
}
