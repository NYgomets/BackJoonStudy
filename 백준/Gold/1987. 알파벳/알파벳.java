import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static String[][] maze;
    static boolean[] visited;
    static int[] directionX = {-1, 1, 0, 0};
    static int[] directionY = {0, 0, -1, 1};
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[26];
        maze = new String[n][m];
        for (int i=0; i<n ;i++) {
            String string = br.readLine();
            for (int j=0; j<m; j++) {
                maze[i][j] = string.substring(j, j+1);
            }
        }

        dfs(0, 0, 1);
        System.out.println(max);
    }

    private static void dfs(int startX, int startY, int path) {
        visited[maze[startX][startY].charAt(0)-'A'] = true;
        max = Math.max(max, path);

        for (int i=0; i<4; i++) {
            int nextX = startX + directionX[i];
            int nextY = startY + directionY[i];

            if (nextX<0 || nextX>=n || nextY<0 || nextY>=m) {
                continue;
            }

            if (!visited[maze[nextX][nextY].charAt(0)-'A']) {
                dfs(nextX,nextY,path+1);
                visited[maze[nextX][nextY].charAt(0)-'A'] = false;
            }
        }
    }
}
