public class SortArrayByParity2 {
    private static int[] sortArrayByParityII(int[] A) {
        int n = A.length;
        int i=0,j=n-1;
        while (i<n && j>=0) {
            if (A[i] % 2 != 0 && A[j] % 2 == 0) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            } else if (A[i]%2==0) {
                i+=2;
            } else if (A[j]%2==1) {
                j-=2;
            } else {
                i+=2;
                j-=2;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[] A = {2,3,1,1,4,0,0,4,3,3};
        int[] res = sortArrayByParityII(A);
        for (int i=0;i<A.length;i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}
