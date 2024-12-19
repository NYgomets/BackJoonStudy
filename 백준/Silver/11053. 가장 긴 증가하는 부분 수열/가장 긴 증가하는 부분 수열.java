import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        int max = 0;
        for (int i=0; i<n; i++) {
            max = Math.max(max, find(i));
        }

        System.out.println(max);
    }

    private static int find(int idx) {
        if (dp[idx] != null) {
            return dp[idx];
        }

        dp[idx] = 1;
        for (int i=idx+1; i<n; i++) {
            if (arr[i] > arr[idx]) {
                dp[idx] = Math.max(dp[idx], 1+find(i));
            }
        }

        return dp[idx];
    }
}