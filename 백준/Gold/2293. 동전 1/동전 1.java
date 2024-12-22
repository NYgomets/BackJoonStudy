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

        System.out.println(find(0, 0));
    }

    private static int find(int current, int idx) {
        if (current == k) {
            return 1;
        } else if (current > k || idx >=n) {
            return 0;
        }
        
        if (dp[current][idx] != null) {
            return dp[current][idx];
        }

        int result = 0;
        result += find(current, idx+1);
        result += find(current+coins[idx], idx);

        dp[current][idx] = result;

        return result;
    }
}