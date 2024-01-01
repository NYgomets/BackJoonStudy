import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int c = 1;
        int d = 1;
        int f = 1;

        for (int i=a-b; i>=1; i--) {
            c *= i;
        }

        for (int i=b; i>=1; i--) {
            d *= i;
        }

        for (int i=a; i>=1; i--) {
            f *= i;
        }

        System.out.println(f/(c*d));
    }
}