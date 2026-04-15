import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] maze;
    static int[][] shortest;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
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

        visited = new boolean[n][n];

        shortest = new int[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (i == 0 && j == 0) {
                    shortest[i][j] = 0;
                } else {
                    shortest[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        dikstra(0, 0);
        System.out.println(shortest[n-1][n-1]);
    }

    private static void dikstra(int startY, int startX) {
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        queue.add(new int[]{startY, startX, shortest[startY][startX]});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentY = poll[0];
            int currentX = poll[1];

            if (visited[currentY][currentX]) {
                continue;
            }
            visited[currentY][currentX] = true;

            for (int i=0; i<4; i++) {
                int nextY = currentY + dy[i];
                int nextX = currentX + dx[i];

                if (nextY<0 || nextY>=n || nextX<0 || nextX>=n) {
                    continue;
                }

                int depth = maze[nextY][nextX] - maze[currentY][currentX];
                depth = Math.abs(depth);

                int newCost = Math.max(shortest[currentY][currentX], depth);

                if (shortest[nextY][nextX] > newCost) {
                    shortest[nextY][nextX] = newCost;
                    queue.add(new int[]{nextY, nextX, shortest[nextY][nextX]});
                }
            }
        }
    }
}