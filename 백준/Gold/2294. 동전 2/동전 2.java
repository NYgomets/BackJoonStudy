import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static Integer[][] dp;
    static int[] coins;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coins = new int[n];
        for (int i = 0; i < n; i++) {
            int c = Integer.parseInt(br.readLine());
            coins[i] = c;
        }

        dp = new Integer[k+1][n];
        int dfs = dfs(0, 0);
        if  (dfs == 10001) {
            System.out.println(-1);
        } else {
            System.out.println(dfs);
        }
    }

    private static int dfs(int curCoin, int index) {
        if (curCoin > k || index >= n) {
            return 10001;
        }

        if (curCoin == k) {
            return 0;
        }

        if (dp[curCoin][index] != null) {
            return dp[curCoin][index];
        }
        
        int min = Integer.MAX_VALUE;
        min = Math.min(min, dfs(curCoin, index+1));
        min = Math.min(min, 1+dfs(curCoin+coins[index], index));

        dp[curCoin][index] = min;
        
        return min;
    }
}