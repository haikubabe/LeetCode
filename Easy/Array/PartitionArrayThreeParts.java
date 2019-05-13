public class PartitionArrayThreeParts {
    private static boolean canThreePartsEqualSum (int[] A) {
        int sum=0, count=0, avg=0;
        for (int i=0;i<A.length;i++) {
            sum += A[i];
        }
        if (sum%3!=0) {
            return false;
        }
        for (int i=0;i<A.length;i++) {
            avg += A[i];
            if (avg == sum/3) {
                avg = 0;
                count++;
                if (count == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] A = {3,3,6,5,-2,2,5,1,-9,4};
        System.out.println(canThreePartsEqualSum(A));
    }
}
