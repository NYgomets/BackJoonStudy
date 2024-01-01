import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        for (int i=0; i<n; i++) {
            int a = s.nextInt();
            int b = s.nextInt();

            int x = 0;

            if (a <= b) {
                int count = 1;

                for (int k=count; k<=a; k++) {
                    if (a%k == 0 && b%k == 0) {
                        count = k;
                    }
                }

                x = count;
            } else {
                int count = 1;

                for (int k=count; k<=b; k++) {
                    if (a%k == 0 && b%k == 0) {
                        count = k;
                    }
                }

                x = count;
            }
            System.out.println((a*b)/x);
        }
    }
}