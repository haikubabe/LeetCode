package Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode - #728
 */
public class SelfDividing
{
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int num=left;num<=right;num++) {
            if (num>=1 && num<10) {
                res.add(num);
            } else {
                boolean canSelfDivide = true;
                int temp = num;
                while (temp > 0) {
                    int rem = temp % 10;
                    if (rem == 0 || num%rem != 0) {
                        canSelfDivide = false;
                        break;
                    }
                    temp /= 10;
                }
                if (canSelfDivide) {
                    res.add(num);
                }
            }
        }
        return res;
    }

    public static void main(String[] args)
    {
        int left = 1, right = 30;
        System.out.println(selfDividingNumbers(left,right));
    }
}
