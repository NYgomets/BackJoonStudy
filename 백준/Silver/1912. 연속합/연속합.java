import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new Integer[n];
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for (int i=0; i<n; i++) {
            max = Math.max(max, dfs(i));
        }
        System.out.println(max);
    }

    private static int dfs(int idx) {
        if (idx >= n) {
            return 0;
        }

        if (dp[idx] != null) {
            return dp[idx];
        }

        dp[idx] = Math.max(arr[idx], arr[idx]+dfs(idx+1));

        return dp[idx];
    }
}
