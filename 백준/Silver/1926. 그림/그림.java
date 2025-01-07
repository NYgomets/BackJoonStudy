import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] maze;
    static boolean[][] visited;
    static int[] directionX = {-1, 1, 0, 0};
    static int[] directionY = {0, 0, -1, 1};
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        maze = new int[n][m];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        int max = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!visited[i][j] && maze[i][j] == 1) {
                    count++;
                    max = Math.max(max, dfs(i, j));
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    private static int dfs(int i, int j) {
        visited[i][j] = true;

        int count = 1;
        for (int l=0; l<4; l++) {
            int nextX = i+directionX[l];
            int nextY = j+directionY[l];

            if (nextX<0||nextX>=n||nextY<0||nextY>=m) {
                continue;
            }

            if (!visited[nextX][nextY] && maze[nextX][nextY] == 1) {
                count += dfs(nextX, nextY);
            }
        }

        return count;
    }
}