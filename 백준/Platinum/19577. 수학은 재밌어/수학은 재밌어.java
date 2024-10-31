import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long answer = -1;

        for (long x=1; x<=Math.sqrt(n); x++) {
            if (n%x == 0) {
                if (x * oiler(x) == n) {
                    answer=x;
                    break;
                }
                long y = n/x;
                if (y*oiler(y) == n) {
                    answer=y;
                    break;
                }
            }
        }
        System.out.println(answer);
    }

    private static long oiler(long x) {
        long result = x;

        for (long i=2; i<=Math.sqrt(x); i++) {
            if (x%i == 0) {
                result = result - (result/i);
                while (x%i == 0) {
                    x = x/i;
                }
            }
        }

        if (x>1) {
            result = result - (result/x);
        }

        return result;
    }
}