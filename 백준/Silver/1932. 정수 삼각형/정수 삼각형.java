import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] tree;
    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new Integer[n][n];
        tree = new int[n][n];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<=i; j++) {
                tree[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(recursive(0, 0));
    }

    private static int recursive(int depth, int direction) {
        if (depth>=n) {
            return 0;
        }

        if (dp[depth][direction] != null) {
            return dp[depth][direction];
        }

        int max = 0;
        max = Math.max(max, tree[depth][direction]+recursive(depth+1, direction));
        max = Math.max(max, tree[depth][direction]+recursive(depth+1, direction+1));

        dp[depth][direction] = max;

        return max;
    }
}