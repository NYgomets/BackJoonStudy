import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static Integer[][] dp;
    static int[][] maze;
    static int MAX = 0;
    static int[] directionX = {-1, 0, 1, 0};
    static int[] directionY = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        dp = new Integer[n][n];
        maze = new int[n][n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                MAX = Math.max(MAX, dfs(i, j));
            }
        }

        System.out.println(MAX);
    }

    private static int dfs(int startX, int startY) {
        if (dp[startX][startY] != null) {
            return dp[startX][startY];
        }

        dp[startX][startY] = 1;

        for (int i=0; i<4; i++) {
            int nextX = startX+directionX[i];
            int nextY = startY+directionY[i];

            if (nextX<0||nextX>=n) {
                continue;
            }
            if (nextY<0||nextY>=n) {
                continue;
            }

            if (maze[nextX][nextY] > maze[startX][startY]) {
                dp[startX][startY] = Math.max(dp[startX][startY], 1+dfs(nextX, nextY));
            }
        }

        return dp[startX][startY];
    }
}