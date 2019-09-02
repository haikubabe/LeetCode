public class SumEvenAfterQueries {
    private static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int queryLen = queries.length;
        int[] answer = new int[queryLen];
        for (int i=0;i<queryLen;i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            A[index] += val;
            int sum=0;
            for (int j=0;j<A.length;j++) {
                if (A[j]%2==0) {
                    sum += A[j];
                }
            }
            answer[i] = sum;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,4};
        int[][] queries = {{1,0},{-3,1},{-4,0},{2,3}};
        int[] answer = sumEvenAfterQueries(A,queries);
        for (int i=0;i<answer.length;i++) {
            System.out.print(answer[i] + " ");
        }
        System.out.println();
    }
}
