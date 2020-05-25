package exercises;

import java.util.ArrayList;
import java.util.List;

public class SumPermutation
{
    private static List<Integer> res;

    public static List<Integer> checkSum(int a, int b, int sum) {
        List<Integer> first = generatePermutation(String.valueOf(a));
        List<Integer> second = generatePermutation(String.valueOf(b));
        List<Integer> result = new ArrayList<>();
        for (int num1 : first) {
            for (int num2 : second) {
                if (num1 + num2 == sum) {
                    result.add(num1);
                    result.add(num2);
                    return result;
                }
            }
        }
        return result;
    }

    private static List<Integer> generatePermutation(String s) {
        res = new ArrayList<>();
        permute(s,0,s.length()-1);
        return res;
    }

    private static String swap(String s, int l, int r) {
        if (l == r) {
            return s;
        }
        char[] ch = s.toCharArray();
        char temp = ch[l];
        ch[l] = ch[r];
        ch[r] = temp;
        return String.valueOf(ch);
    }

    private static void permute(String s, int l, int r) {
        if (l == r) {
            res.add(Integer.parseInt(s));
        } else {
            for (int i=l;i<=r;i++) {
                s = swap(s,l,i);
                permute(s,l+1,r);
                s = swap(s,l,i);
            }
        }
    }

    public static void main(String[] args)
    {
        int a = 100, b = 250;
        int sum = 620;
        System.out.println(checkSum(a,b,sum));
    }
}
