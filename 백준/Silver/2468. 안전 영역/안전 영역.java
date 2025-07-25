import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] maze;
    static boolean[][] visited;
    static int[] directionX = {-1, 0, 1, 0};
    static int[] directionY = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        maze = new int[n][n];
        int max = 0;

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(maze[i][j], max);
            }
        }

        int result = 0;
        for (int i=0; i<=max; i++) {
            visited = new boolean[n][n];
            int check = flood(i);
            result = Math.max(result, check);
        }
        System.out.println(result);
    }

    private static int flood(int water) {
        int num = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (maze[i][j] > water && !visited[i][j]) {
                    num++;
                    bfs(i, j, water);
                }
            }
        }
        return num;
    }

    private static void bfs(int startX, int startY, int water) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            for (int i=0; i<4; i++) {
                int nextX = currentX+directionX[i];
                int nextY = currentY+directionY[i];

                if (nextX<0 || nextX>=n) {
                    continue;
                }
                if (nextY<0 || nextY>=n) {
                    continue;
                }

                if (maze[nextX][nextY] > water && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }
}