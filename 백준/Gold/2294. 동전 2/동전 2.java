import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static int[] coins;
    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new Integer[k+1][n];
        coins = new int[n];
        for (int i=0; i<n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int result = find(0, 0);
        if (result == 10001) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static int find(int current, int idx) {
        if (current>k || idx>=n) {
            return 10001;
        } else if (current == k) {
            return 0;
        }

        if (dp[current][idx] != null) {
            return dp[current][idx];
        }

        int min = Integer.MAX_VALUE;
        min = Math.min(min, find(current, idx+1));
        min = Math.min(min, 1+find(current+coins[idx], idx));

        dp[current][idx] = min;

        return min;
    }
}