import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int l=0; l<t; l++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            dp = new int[30][30];

            System.out.println(find(right, left));
        }
    }

    private static int find(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        }

        if (n==r || r==0) {
            return dp[n][r] = 1;
        }

        return dp[n][r] = find(n-1, r-1) + find(n-1, r);
    }


}