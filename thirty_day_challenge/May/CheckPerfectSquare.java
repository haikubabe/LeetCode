package thirty_day_challenge.May;

public class CheckPerfectSquare
{
    public static boolean isPerfectSquare(int num) {
        int i=1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    public static void main(String[] args)
    {
        int num = 14;
        System.out.println(isPerfectSquare(num));
    }
}
