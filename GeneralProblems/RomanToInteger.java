public class RomanToInteger {
    private static int romanToInt(String s) {
        int[] a = new int[26];
        a['I'-'A'] = 1;
        a['V'-'A'] = 5;
        a['X'-'A'] = 10;
        a['L'-'A'] = 50;
        a['C'-'A'] = 100;
        a['D'-'A'] = 500;
        a['M'-'A'] = 1000;

        int prev=0,num=0;
        for (char c : s.toCharArray()) {
            int curr = c-'A';
            if (a[curr]>a[prev]) {
                num += a[curr] - (2*a[prev]);
            } else {
                num += a[curr];
            }
            prev = curr;
        }
        return num;
    }

    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }
}
