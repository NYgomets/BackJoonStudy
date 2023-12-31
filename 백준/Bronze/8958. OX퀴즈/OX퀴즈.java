import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        for (int i=0; i<n; i++) {
            String a = s.next();
            int sum = 0;
            int suc = 1;

            for (int j=0; j<a.length(); j++) {
                char c = a.charAt(j);

                if (c == 'O') {
                    sum += suc;
                    suc++;
                } else {
                    suc = 1;
                }
            }
            System.out.println(sum);
        }
    }
}