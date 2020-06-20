package Easy;

/**
 * Leetcode - #1108
 */
public class DefangIPAddress
{
    public static String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }

    public static void main(String[] args)
    {
        String address = "255.100.50.0";
        System.out.println(defangIPaddr(address));
    }
}
