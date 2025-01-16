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
        dp = new Integer[n][3];
        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(dfs(0, 0));
    }

    private static int dfs(int current, int count) {
        if (current == n) {
            return 0;
        }

        if (dp[current][count] != null) {
            return dp[current][count];
        }

        int check = 0;
        if (count<2) {
            check = Math.max(arr[current]+dfs(current+1, count+1), dfs(current+1, 0));
        } else {
            check = Math.max(check, dfs(current+1, 0));
        }

        dp[current][count] = check;

        return check;
    }
}