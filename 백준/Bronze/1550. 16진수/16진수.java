import java.math.BigInteger;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String n = s.next();
        int idx = n.length()-1;
        int sum = 0;

        for (int i=0; i<n.length(); i++) {
            char c = n.charAt(i);

            if (c >= '0' && c <= '9') {
                int a = Integer.valueOf(c - '0');
                sum += (int) (Math.pow(16, idx)*a);
                idx--;
            } else {
                int a = Integer.valueOf((c - 'A') + 10);
                sum += (int) (Math.pow(16, idx)*a);
                idx--;
            }
        }

        System.out.println(sum);
    }
}