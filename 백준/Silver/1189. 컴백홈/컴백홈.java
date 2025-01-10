import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int k;
    static String[][] maze;
    static boolean[][] visited;
    static int[] directionX = {-1, 1, 0, 0};
    static int[] directionY = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        maze = new String[n][m];
        for (int i=0; i<n; i++) {
            String string = br.readLine();
            for (int j=0; j<m; j++) {
                maze[i][j] = string.substring(j, j+1);
            }
        }
        visited = new boolean[n][m];
        visited[n-1][0] = true;
        System.out.println(dfs(n-1, 0, 1));
    }

    private static int dfs(int x, int y, int dis) {
        if (x==0 && y==m-1 && dis==k) {
            return 1;
        } else if (dis>k){
            return 0;
        }

        int count = 0;
        for (int i=0; i<4; i++) {
            int nextX = x+directionX[i];
            int nextY = y+directionY[i];

            if (nextX<0||nextX>=n||nextY<0||nextY>=m) {
                continue;
            }

            if (!visited[nextX][nextY] && !maze[nextX][nextY].equals("T")) {
                visited[nextX][nextY] = true;
                count += dfs(nextX, nextY, dis+1);
                visited[nextX][nextY] = false;
            }
        }

        return count;
    }
}