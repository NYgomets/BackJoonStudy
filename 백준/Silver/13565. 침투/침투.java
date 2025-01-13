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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        maze = new int[n][m];
        for (int i=0; i<n; i++) {
            String string = br.readLine();
            for (int j=0; j<m; j++) {
                maze[i][j] = Integer.parseInt(string.substring(j, j+1));
            }
        }

        for (int j=0; j<m; j++) {
            if (!visited[0][j]) {
                bfs(0, j);
            }
        }

        for (int j=0; j<m; j++) {
            if (visited[n-1][j]) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            for (int i=0; i<4; i++) {
                int nextX = currentX+directionX[i];
                int nextY = currentY+directionY[i];

                if (nextX<0||nextX>=n||nextY<0||nextY>=m) {
                    continue;
                }
                if (visited[nextX][nextY]) {
                    continue;
                }

                if (maze[nextX][nextY] == 0) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }
}