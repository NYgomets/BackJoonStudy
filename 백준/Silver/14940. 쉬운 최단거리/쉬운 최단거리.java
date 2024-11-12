import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static boolean[][] visitedArr;
    static int[][] maze;
    static long INF = Integer.MAX_VALUE;
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visitedArr = new boolean[n][m];
        maze = new int[n][m];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
                if (maze[i][j] == 2) {
                    queue.offer(new int[]{i, j, 0});
                    maze[i][j] = 0;
                    visitedArr[i][j] = true;
                }
            }
        }

        bfs();

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!visitedArr[i][j] && maze[i][j] != 0) {
                    System.out.print(-1 + " ");
                } else {
                    System.out.print(maze[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];
            int weight = poll[2];

            int[] directionX = {-1, 1, 0, 0};
            int[] directionY = {0, 0, -1, 1};

            for (int i=0; i<4; i++) {
                int nextX = currentX + directionX[i];
                int nextY = currentY + directionY[i];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                    if (maze[nextX][nextY] == 1 && !visitedArr[nextX][nextY]) {
                        visitedArr[nextX][nextY] = true;
                        maze[nextX][nextY] = weight+1;
                        queue.offer(new int[]{nextX, nextY, weight+1});
                    }
                }
            }
        }
    }
}