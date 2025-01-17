import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new Integer[n+1][n+1];
        arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(dfs(1, 0));
    }

    private static int dfs(int idx, int count) {
        if (idx > n) {
            return 0;
        }

        if (dp[idx][count] != null) {
            return dp[idx][count];
        }

        int price = 0;
        if (idx+count <= n) {
            price = Math.max(dfs(idx+1, count), arr[idx]+dfs(idx, idx+count));
        } else {
            price = Math.max(price,dfs(idx+1, count));
        }

        dp[idx][count] = price;

        return price;
    }
}