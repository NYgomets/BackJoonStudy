import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int l=1; l<=t; l++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            long q = Long.parseLong(st.nextToken());

            sb.append("Case #"+l+": "+fibo(p, q)).append("\n");
        }
        System.out.println(sb);
    }

    private static long fibo(int p, long q) {
        if (p<=1) {
            return p%q;
        }

        long prev2 = 0;
        long prev1 = 1;
        for (int i=2; i<=p; i++) {
            long result = (prev2+prev1)%q;
            prev2 = prev1;
            prev1 = result;
        }

        return prev1;
    }
}