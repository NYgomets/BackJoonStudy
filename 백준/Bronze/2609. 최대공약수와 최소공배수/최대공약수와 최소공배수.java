import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int m = s.nextInt();

        int x = 0;

        if (n <= m) {
            int count = 1;

            for (int i=count; i<=n; i++) {
                if (n%i == 0 && m%i == 0) {
                    count = i;
                }
            }

            x = count;
        } else {
            int count = 1;

            for (int i=count; i<=m; i++) {
                if (n%i == 0 && m%i == 0) {
                    count = i;
                }
            }

            x = count;
        }

        System.out.println(x);
        System.out.println(n/x * m/x * x);
    }
}