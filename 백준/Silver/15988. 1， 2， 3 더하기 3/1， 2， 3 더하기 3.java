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
        int maxN = 0;
        
        int[] q = new int[t];
        for (int i=0; i<t; i++) {
            q[i] = Integer.parseInt(br.readLine());
            maxN = Math.max(maxN, q[i]);
        }
        
        dp = new long[maxN+1];
        dp[0] = 1;
        if (maxN>=1) dp[1] = 1;
        if (maxN>=2) dp[2] = 2;
        if (maxN>=3) dp[3] = 4;
        
        for (int i=4; i<=maxN; i++) {
            dp[i] = (dp[i-3]+dp[i-2]+dp[i-1])%mod;
        }

        for (int i : q) {
            System.out.println(dp[i]);
        }
    }
}