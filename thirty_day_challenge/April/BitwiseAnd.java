package thirty_day_challenge.April;

public class BitwiseAnd {

    /** brute force
     */
    public static int rangeBitwiseAnd1(int m, int n) {
        int res = m;
        for (int i=m+1;i<=n;i++) {
            res &= i;
        }
        return res;
    }

    public static int rangeBitwiseAnd(int m, int n) {
        if (m == 0) {
            return 0;
        }
        int moveFactor = 1;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            moveFactor <<= 1;
        }
        return m * moveFactor;
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(0,1));
    }
}
