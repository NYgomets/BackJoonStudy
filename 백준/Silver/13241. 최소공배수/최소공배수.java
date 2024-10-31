import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long gcd = gcd(n,m);

        long result = (n*m) / gcd;
        System.out.println(result);

    }

    private static long gcd(long max, long min) {
        if (max%min != 0) {
            long temp = min;
            min = max % min;
            max = temp;
            return gcd(max, min);
        } else {
            return min;
        }
    }
}