import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] left;
    static int[] right;
    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        left = new int[n];
        right = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            left[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            right[i] = Integer.parseInt(st.nextToken());
        }

        dp = new Integer[n][n];
        int result = dfs(0, 0);
        System.out.println(result);
    }

    private static int dfs(int leftIndex, int rightIndex) {
        if (leftIndex >=n || rightIndex >= n) {
            return 0;
        }

        if (dp[leftIndex][rightIndex] != null) {
            return dp[leftIndex][rightIndex];
        }
        
        int max = 0;
        max = Math.max(max, dfs(leftIndex+1, rightIndex));
        max = Math.max(max, dfs(leftIndex+1, rightIndex+1));
        if (left[leftIndex] > right[rightIndex]) {
            max = Math.max(max, right[rightIndex] + dfs(leftIndex, rightIndex+1));
        }

        dp[leftIndex][rightIndex] = max;
        
        return max;
    }
}