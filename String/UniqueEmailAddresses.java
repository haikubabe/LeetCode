import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    private static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String str : emails) {
            String[] email = str.split("@");
            String localName = email[0];
            String domainName = email[1];
            if (localName.contains("+")) {
                localName = localName.substring(0,localName.indexOf('+'));
            }
            localName = localName.replaceAll("\\.", "");
            set.add(localName.concat("@" + domainName));
        }
        return set.size();
    }

    public static void main(String[] args) {
        String[] emails = {"testemail@leetcode.com","testemail1@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));
    }
}
