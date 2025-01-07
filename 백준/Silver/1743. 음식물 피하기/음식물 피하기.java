import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int k;
    static int[][] maze;
    static boolean[][] visited;
    static int[] directionX = {-1, 1, 0, 0};
    static int[] directionY = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1][m+1];
        maze = new int[n+1][m+1];
        for (int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            maze[x][y] = 1;
        }

        int max = 0;
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                if (!visited[i][j] && maze[i][j] == 1) {
                    max = Math.max(max, dfs(i, j));
                }
            }
        }

        System.out.println(max);
    }

    private static int dfs(int x, int y) {
        visited[x][y] = true;

        int count = 1;
        for (int i=0; i<4; i++) {
            int nextX = x+directionX[i];
            int nextY = y+directionY[i];

            if (nextX<1||nextX>n||nextY<1||nextY>m) {
                continue;
            }
            if (visited[nextX][nextY]) {
                continue;
            }

            if (maze[nextX][nextY] == 1) {
                count += dfs(nextX, nextY);
            }
        }

        return count;
    }
}