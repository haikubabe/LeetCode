package thirty_day_challenge.April;

public class PerformStringShifts
{
    public static String stringShift(String s, int[][] shift) {
        int left=0,right=0;
        for (int i=0;i<shift.length;i++) {
            // left shift
            if (shift[i][0] == 0) {
                left += shift[i][1];
            }
            // right shift
            else {
                right += shift[i][1];
            }
        }
        int shiftD = left-right;
        if (shiftD == 0 || Math.abs(shiftD) == s.length()) {
            return s;
        }
        StringBuilder str = new StringBuilder(s);
        String delStr = "";
        if (shiftD > 0) {
            while (shiftD>=s.length()) {
                shiftD = shiftD-s.length();
            }
            // left shift
            if (shiftD > 0) {
                for (int i=0;i<shiftD;i++) {
                    delStr += s.charAt(i);
                }
                str.delete(0,shiftD);
                str.append(delStr);
            }
        } else {
            shiftD = Math.abs(shiftD);
            while (shiftD>=s.length()) {
                shiftD = shiftD-s.length();
            }
            // right shift
            int start = str.length()-shiftD;
            if (start>0) {
                for (int i=start;i<str.length();i++) {
                    delStr += s.charAt(i);
                }
                str.delete(start,str.length());
                str.insert(0,delStr);
            }
        }
        return str.toString();
    }

    public static void main(String[] args)
    {
        String s = "abcdefg";
        int[][] shift = {{1,1},{1,1},{0,2},{1,3}};
        System.out.println(stringShift(s,shift));
    }
}
