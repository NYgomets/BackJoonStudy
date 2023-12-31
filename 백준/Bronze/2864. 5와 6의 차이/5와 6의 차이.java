import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        String a = s.next();
        String b = s.next();

        String sresult = "";
        String mresult = "";
        String s2result = "";
        String m2result = "";

        for (int i=0; i<a.length(); i++) {
            char c = a.charAt(i);

            if (c == '6') {
                sresult += "5";
            } else {
                sresult += c;
            }
        }

        for (int i=0; i<a.length(); i++) {
            char c = a.charAt(i);

            if (c == '5') {
                mresult += "6";
            } else {
                mresult += c;
            }
        }

        for (int i=0; i<b.length(); i++) {
            char c = b.charAt(i);

            if (c == '6') {
                s2result += "5";
            } else {
                s2result += c;
            }
        }

        for (int i=0; i<b.length(); i++) {
            char c = b.charAt(i);

            if (c == '5') {
                m2result += "6";
            } else {
                m2result += c;
            }
        }

        Integer i = Integer.valueOf(sresult);
        Integer i1 = Integer.valueOf(mresult);

        Integer i2 = Integer.valueOf(s2result);
        Integer i3 = Integer.valueOf(m2result);

        System.out.println((i+i2) + " " + (i1+i3));
    }
}