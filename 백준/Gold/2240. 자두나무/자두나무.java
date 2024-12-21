import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int t;
    static int w;
    static int[][] arr;
    static Integer[][][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        dp = new Integer[t+1][3][w+1];
        arr = new int[t+1][3];
        for (int i=1; i<=t; i++) {
            int c = Integer.parseInt(br.readLine());
            arr[i][c] = 1;
        }

        System.out.println(find(0, 1, 0));
    }

    private static int find(int time, int position, int move) {
        if (time>t) {
            return 0;
        }

        if (dp[time][position][move] != null) {
            return dp[time][position][move];
        }

        int max = 0;
        max = Math.max(max, arr[time][position]+find(time+1, position, move));
        if (position == 1 && move < w) {
            max = Math.max(max, arr[time][position]+find(time+1, position+1, move+1));
        } else if (position == 2 && move < w) {
            max = Math.max(max, arr[time][position]+find(time+1, position-1, move+1));
        }

        dp[time][position][move] = max;

        return max;
    }
}