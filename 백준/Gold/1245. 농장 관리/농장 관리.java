import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
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

        int result = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!visited[i][j]) {
                    if (bfs(i, j)) {
                        result++;
                    }
                }
            }
        }

        System.out.println(result);
    }

    private static boolean bfs(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startY, startX});
        visited[startY][startX] = true;
        boolean isParked = true;
        int max = maze[startY][startX];

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curY = poll[0];
            int curX = poll[1];

            for (int i=0; i<8; i++) {
                int nextY = curY + dy[i];
                int nextX = curX + dx[i];

                if (nextX<0 || nextX>=m || nextY<0 || nextY>=n) {
                    continue;
                }

                if (maze[nextY][nextX] > max) {
                    isParked = false;
                }

                if (maze[nextY][nextX] == max && !visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    queue.add(new int[] {nextY, nextX});
                }
            }
        }

        return isParked;
    }
}