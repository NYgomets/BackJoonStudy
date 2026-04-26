import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int t;
    static int[][] maze;
    static boolean[][][] visited;
    static int[][][] shortest;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        shortest = new int[n][m][2];
        for (int j=0; j<n; j++) {
            for (int k=0; k<m; k++) {
                for (int i=0; i<2; i++) {
                    shortest[j][k][i] = Integer.MAX_VALUE;
                }
            }
        }
        shortest[0][0][0] = 0;
        shortest[0][0][1] = 0;

        visited = new boolean[n][m][2];
        maze = new int[n][m];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dikstra(0,0);
        int result = Integer.MAX_VALUE;
        result = Math.min(Math.min(result, shortest[n-1][m-1][0]), shortest[n-1][m-1][1]);
        if (result == Integer.MAX_VALUE || result > t) {
            System.out.println("Fail");
        } else {
            System.out.println(result);
        }
    }

    private static void dikstra(int startY, int startX) {
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        queue.add(new int[]{startY, startX, 0, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curY = poll[0];
            int curX = poll[1];
            int curTime = poll[2];
            int sword = poll[3];

            if (visited[curY][curX][sword]) {
                continue;
            }
            visited[curY][curX][sword] = true;

            for (int i=0; i<4; i++) {
                int nextY = curY + dy[i];
                int nextX = curX + dx[i];
                int nextSword = sword;

                if (nextX<0 || nextX>=m || nextY<0 || nextY>=n) {
                    continue;
                }

                if (maze[nextY][nextX] == 1 && sword == 0) {
                    continue;
                }
                if (maze[nextY][nextX] == 2) {
                    nextSword = 1;
                }

                if (shortest[nextY][nextX][nextSword] > curTime + 1) {
                    shortest[nextY][nextX][nextSword] = curTime + 1;
                    queue.add(new int[]{nextY, nextX, shortest[nextY][nextX][nextSword], nextSword});
                }
            }
        }
    }
}