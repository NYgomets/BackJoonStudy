import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] maze;
    static int[][] arr;
    static boolean[][] visited;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new int[n][m];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(result);
    }

    private static void dfs(int wall) {
        if (wall == 3) {
            bfs();
            maxSafe();
            return;
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (maze[i][j] == 0) {
                    maze[i][j] = 1;
                    dfs(wall+1);
                    maze[i][j] = 0;
                }
            }
        }
    }

    private static void maxSafe() {
        int count = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (arr[i][j] == 0) {
                    count++;
                }
            }
        }

        if (result < count) {
            result = count;
        }
    }

    private static void bfs() {
        visited = new boolean[n][m];
        arr = new int[n][m];
        for (int i=0; i<n; i++) {
            arr[i] = maze[i].clone();
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (arr[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            if (visited[currentX][currentY]) {
                continue;
            }
            visited[currentX][currentY] = true;

            int[] directionX = {-1, 1, 0, 0};
            int[] directionY = {0, 0, -1, 1};

            for (int i=0; i<4; i++) {
                int nextX = currentX + directionX[i];
                int nextY = currentY + directionY[i];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                    continue;
                }

                if (arr[nextX][nextY] == 0) {
                    arr[nextX][nextY] = 2;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }
}
