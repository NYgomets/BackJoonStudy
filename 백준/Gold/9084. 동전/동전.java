import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int goal;
    static int[] coins;
    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int z=0; z<t; z++) {
            n =  Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            coins = new int[n];
            for (int i=0; i<n; i++) {
                coins[i] = Integer.parseInt(st.nextToken());
            }

            dp = new Integer[n][200001];
            goal = Integer.parseInt(br.readLine());

            int result = dfs(0, 0);
            System.out.println(result);
        }
    }

    private static int dfs(int index, int current) {
        if (index >=n || current > goal) {
            return 0;
        }

        if (current == goal) {
            return 1;
        }

        if  (dp[index][current] != null) {
            return dp[index][current];
        }

        int count = 0;
        count += dfs(index, current+coins[index]);
        count += dfs(index+1, current);

        dp[index][current] = count;

        return count;
    }
}