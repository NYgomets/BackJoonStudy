import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static Integer[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int l = 0; l < t; l++) {
            n = Integer.parseInt(br.readLine());
            dp = new Integer[2][n];
            arr = new int[2][n];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = Math.max(find(0,0), find(1,0));
            System.out.println(result);
        }
    }

    private static int find(int x, int y) {
        if (y>=n) {
            return 0;
        }

        if (dp[x][y] != null) {
            return dp[x][y];
        }

        int select = arr[x][y] + find(1-x, y+1);
        int skip = find(x, y+1);

        int max = Math.max(select, skip);

        dp[x][y] = max;

        return max;
    }
}