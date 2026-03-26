import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int k;
    static int w;
    static int h;
    static int[][] maze;
    static boolean[][][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[] hdx = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[] hdy = {-1, -2, -2, -1, 1, 2, 2, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        maze = new int[h][w];
        for (int i=0; i<h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<w; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[h][w][k+1];

        int result = bfs(0, 0, 0, 0);

        if  (result == -1) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static int bfs(int startX, int startY, int count, int horse) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startX, startY, count, horse});
        visited[startY][startX][horse] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curX = poll[0];
            int curY = poll[1];
            int curCount = poll[2];
            int curHorse = poll[3];

            if (curX == w-1 && curY == h-1) {
                return curCount;
            }

            for (int i=0; i<4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX<0 || nextX>=w || nextY<0 || nextY>=h) {
                    continue;
                }

                if (!visited[nextY][nextX][curHorse] && maze[nextY][nextX] == 0) {
                    visited[nextY][nextX][curHorse] = true;
                    queue.add(new int[] {nextX, nextY, curCount+1, curHorse});
                }
            }

            if (curHorse+1 <= k) {
                for (int i=0; i<8; i++) {
                    int nextX = curX + hdx[i];
                    int nextY = curY + hdy[i];

                    if (nextX<0 || nextX>=w || nextY<0 || nextY>=h) {
                        continue;
                    }

                    if (!visited[nextY][nextX][curHorse+1] && maze[nextY][nextX] == 0) {
                        visited[nextY][nextX][curHorse+1] = true;
                        queue.add(new int[] {nextX, nextY, curCount+1, curHorse+1});
                    }

                }
            }
        }

        return -1;
    }
}