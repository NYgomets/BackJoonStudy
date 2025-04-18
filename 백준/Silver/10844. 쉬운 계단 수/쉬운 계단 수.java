import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int mod = 1000000000;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[n+1][10];

        for (int i=1; i<=9; i++) {
            dp[1][i] = 1;
        }

        for (int i=2; i<=n; i++) {
            for (int j=0; j<=9; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j+1]%mod;
                } else if (j==9) {
                    dp[i][j] = dp[i-1][j-1]%mod;
                } else {
                    dp[i][j] = (dp[i-1][j+1]+dp[i-1][j-1])%mod;
                }
            }
        }

        long result = 0;
        for (int i=0; i<=9; i++) {
            result += dp[n][i];
        }

        System.out.println(result%mod);
    }
}