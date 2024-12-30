import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int mod = 1000000009;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] q = new int[t];
        int maxN = 0;
        for (int i=0; i<t; i++) {
            int a = Integer.parseInt(br.readLine());
            q[i] = a;
            maxN = Math.max(maxN, a);
        }

        dp = new long[maxN+1];
        dp[0] = 1;
        dp[1] = 1;
        if (maxN>=2) dp[2] = 2;
        if (maxN>=3) dp[3] = 2;
        if (maxN>=4) dp[4] = 3;
        if (maxN>=5) dp[5] = 3;

        for (int i=6; i<=maxN; i++) {
            dp[i] = (dp[i-6]+dp[i-4]+dp[i-2])%mod;
        }

        for (int i : q) {
            System.out.println(dp[i]);
        }
    }
}