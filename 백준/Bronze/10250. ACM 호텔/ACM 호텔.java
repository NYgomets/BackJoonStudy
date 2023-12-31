import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int p = s.nextInt();

        for (int i=0; i<p; i++) {
            int h = s.nextInt();
            int w = s.nextInt();
            int n = s.nextInt();

            int ch = 0;
            int cw = 0;
            for (int j=1; j<=w; j++) {
                for (int k=1; k<=h; k++) {
                    n--;

                    if (n==0) {
                        ch = k;
                        cw = j;
                    }
                }
            }

            if (cw<10) {
                System.out.println(ch + "0" + cw);
            } else {
                System.out.println(ch + "" + cw);
            }
        }
    }
}