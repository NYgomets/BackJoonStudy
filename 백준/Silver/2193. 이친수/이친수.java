import java.io.*;
import java.util.*;

public class Main {
    static Long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new Long[n+1];
        dp[0] = 0L;
        dp[1] = 1L;
        if (n>=2) {
            dp[2] = 1L;
        }
        for (int i=3; i<=n; i++) {
            dp[i] = dp[i-2]+dp[i-1];
        }

        System.out.println(dp[n]);
    }
}
