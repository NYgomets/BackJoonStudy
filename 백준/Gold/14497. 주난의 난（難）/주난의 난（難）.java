import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] shortest;
    static int[][] maze;
    static boolean[][] visited;
    static int juX;
    static int juY;
    static int criX;
    static int criY;
    static int[] directionX = {-1, 1, 0, 0};
    static int[] directionY = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1][m+1];
        maze = new int[n+1][m+1];
        st = new StringTokenizer(br.readLine());
        juX = Integer.parseInt(st.nextToken());
        juY = Integer.parseInt(st.nextToken());
        criX = Integer.parseInt(st.nextToken());
        criY = Integer.parseInt(st.nextToken());

        for (int i=1; i<=n; i++) {
            String string = br.readLine();
            for (int j=1; j<=m; j++) {
                String substring = string.substring(j-1, j);
                if (substring.equals("*")) {
                    maze[i][j] = 0;
                } else if (substring.equals("#")) {
                    maze[i][j] = 1;
                } else {
                    maze[i][j] = Integer.parseInt(substring);
                }
            }
        }

        shortest = new int[n+1][m+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                shortest[i][j] = Integer.MAX_VALUE;
            }
        }
        shortest[juX][juY] = 0;
        System.out.println(bfs(juX, juY));

    }

    private static int bfs(int startX, int startY) {
        Queue<int[]> queue = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1[2], o2[2])));
        visited[startX][startY] = true;
        queue.add(new int[]{startX, startY, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];
            int count = poll[2];

            if (currentX==criX&&currentY==criY) {
                return count;
            }

            for (int i=0; i<4; i++) {
                int nextX = currentX+directionX[i];
                int nextY = currentY+directionY[i];

                if (nextX<1||nextX>n||nextY<1||nextY>m) {
                    continue;
                }
                if (visited[nextX][nextY]) {
                    continue;
                }

                if (shortest[nextX][nextY] > shortest[currentX][currentY]+maze[nextX][nextY]) {
                    shortest[nextX][nextY] = shortest[currentX][currentY]+maze[nextX][nextY];
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY, shortest[nextX][nextY]});
                }
            }
        }

        return -1;
    }
}