public class ClimbingStairs {
    //Memoization Technique
    private static int climbStairs(int n) {
        int[] fib = new int[n+1];
        if (fib[n] == 0) {
            if (n == 1 || n == 2) {
                fib[n] = n;
            } else {
                fib[n] = climbStairs(n-1) + climbStairs(n-2);
            }
        }
        return fib[n];
    }

    //Tabulation Approach
    private static int climbStairsT(int n) {
        int[] fib = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;
        fib[2] = 2;
        for (int i=3;i<=n;i++) {
            fib[i] = fib[i-1]+fib[i-2];
        }
        return fib[n];
    }

    public static void main(String[] args) {
        int n=4;
        System.out.println(climbStairsT(n));
    }
}
