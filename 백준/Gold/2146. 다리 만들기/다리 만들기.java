import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] maze;
    static boolean[][] island;
    static int[] directionX = {-1, 1, 0, 0};
    static int[] directionY = {0, 0, -1, 1};
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        maze = new int[n][n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (maze[i][j] == 1) {
                    island = new boolean[n][n];
                    dfs(i, j);
                    bfs(i, j);
                }
            }
        }

        System.out.println(min);
    }

    private static void dfs(int x, int y) {
        island[x][y] = true;

        for (int i=0; i<4; i++) {
            int nextX = x+directionX[i];
            int nextY = y+directionY[i];

            if (nextX<0||nextX>=n||nextY<0||nextY>=n) {
                continue;
            }
            if (island[nextX][nextY]) {
                continue;
            }
            if (maze[nextX][nextY] == 1) {
                dfs(nextX, nextY);
            }
        }
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        queue.add(new int[]{x, y, 0});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];
            int currentL = poll[2];

            for (int i=0; i<4; i++) {
                int nextX = currentX+directionX[i];
                int nextY = currentY+directionY[i];

                if (nextX<0||nextX>=n||nextY<0||nextY>=n) {
                    continue;
                }
                if (visited[nextX][nextY]) {
                    continue;
                }
                if (maze[nextX][nextY] == 1 && currentL==0) {
                    continue;
                }
                if (maze[nextX][nextY] == 1 && !island[nextX][nextY] && currentL != 0) {
                    min = Math.min(min, currentL);
                }

                if (maze[nextX][nextY] == 0) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY, currentL+1});
                }
            }
        }
    }
}
