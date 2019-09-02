public class HammingDistance {
    private static int hammingDistance(int x, int y) {
        int num = x ^ y;
        int count = 0;
        while (num != 0) {
            count++;
            num = num & (num-1);
        }
        return count;
    }

    public static void main(String[] args) {
        int x=1, y=5;
        System.out.println(hammingDistance(x,y));
    }
}
