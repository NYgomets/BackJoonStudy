import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static long[][] dp;
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

        dp = new long[maxN+1][4];
        dp[1][1] = 1;
        dp[1][2] = 0;
        dp[1][3] = 0;

        if (maxN>=2) {
            dp[2][1] = 1;
            dp[2][2] = 1;
            dp[2][3] = 0;
        }
        if (maxN>=3) {
            dp[3][1] = 1;
            dp[3][2] = 1;
            dp[3][3] = 1;
        }

        for (int i=4; i<=maxN; i++) {
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1]+dp[i-2][2];
            dp[i][3] = dp[i-3][1]+dp[i-3][2]+dp[i-3][3];
        }

        for (int i : q) {
            System.out.println(dp[i][1]+dp[i][2]+dp[i][3]);
        }
    }
}