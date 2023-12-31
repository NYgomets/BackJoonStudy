import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        while (true) {
            String num = s.next();

            if (num.equals("0")) {
                return;
            }

            boolean drom = false;
            String check = "";

            for (int i=num.length()-1; i>=0; i--) {
                char c = num.charAt(i);
                check += c;
            }

            for (int i=0; i<num.length(); i++) {
                if (num.charAt(i) == check.charAt(i)) {
                    drom = true;
                } else {
                    drom = false;
                    break;
                }
            }

            if (drom) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}