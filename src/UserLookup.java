import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserLookup {

    public static void main(String[] args) throws Exception {
        System.out.print("Username: ");
        String id = new Scanner(System.in).next().trim();
        String body = new Scanner(new URL("http://ecs.soton.ac.uk/people/" + id).openStream()).useDelimiter("^").next();
        Matcher m = Pattern.compile("tel:(.*?)'.*mailto:(.*?)'.*property=\"name\">(.*?)<").matcher(body);
        System.out.println(m.find() ? m.group(3) + "\n" + m.group(2) + "\n" + m.group(1) : "N/A");
    }

    // NOTE: Scanner should be closed, I omitted that for brevity.

}
