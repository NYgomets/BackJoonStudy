import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[][] maze;
    static Integer[][] dp;
    static int[] directionX = {-1, 0, 1, 0};
    static int[] directionY = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        dp = new Integer[n][m];
        maze = new int[n][m];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = dfs(0, 0);
        System.out.println(result);
    }

    private static int dfs(int startX, int startY) {
        if (startX==n-1&&startY==m-1) {
            return 1;
        }

        if (dp[startX][startY] != null) {
            return dp[startX][startY];
        }

        int result = 0;
        for (int i=0; i<4; i++) {
            int nextX = startX+directionX[i];
            int nextY = startY+directionY[i];

            if (nextX<0||nextX>=n) {
                continue;
            }
            if (nextY<0||nextY>=m) {
                continue;
            }

            if(maze[nextX][nextY] < maze[startX][startY]) {
                result += dfs(nextX, nextY);
            }
        }

        dp[startX][startY] = result;

        return result;
    }
}