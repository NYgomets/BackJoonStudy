import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] maze = new int[501][501];
    static boolean[][] visited = new boolean[501][501];
    static int[] directionX = {-1, 1, 0, 0};
    static int[] directionY = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(br.readLine());
        for (int l=0; l<first; l++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int startX = Math.min(x1, x2);
            int endX = Math.max(x1, x2);
            int startY = Math.min(y1, y2);
            int endY = Math.max(y1, y2);

            for (int i=startX; i<=endX; i++) {
                for (int j=startY; j<=endY; j++) {
                    maze[i][j] = 1;
                }
            }
        }

        int second = Integer.parseInt(br.readLine());
        for (int l=0; l<second; l++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int startX = Math.min(x1, x2);
            int endX = Math.max(x1, x2);
            int startY = Math.min(y1, y2);
            int endY = Math.max(y1, y2);

            for (int i=startX; i<=endX; i++) {
                for (int j=startY; j<=endY; j++) {
                    maze[i][j] = -1;
                }
            }
        }

        System.out.println(bfs(0, 0));
    }

    private static int bfs(int startX, int startY) {
        Queue<int[]> queue = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1[2], o2[2])));
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];
            int distance = poll[2];

            if (currentX==500&&currentY==500) {
                return distance;
            }

            for (int i=0; i<4; i++) {
                int nextX = currentX+directionX[i];
                int nextY = currentY+directionY[i];

                if (nextX<0||nextX>500||nextY<0||nextY>500) {
                    continue;
                }
                if (visited[nextX][nextY]) {
                    continue;
                }

                if (maze[nextX][nextY]==0 || maze[nextX][nextY]==1) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY, distance+maze[nextX][nextY]});
                }
            }
        }

        return -1;
    }
}