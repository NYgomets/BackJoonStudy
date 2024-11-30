import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int l;
    static int r;
    static int[][] maze;
    static boolean[][] allow;
    static boolean[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        maze = new int[n][n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int day = 0;
        while (true) {
            allow = new boolean[n][n];
            boolean same = true;
            for (int i=0; i<n; i++) {
                for (int j=0; j<n; j++) {
                    if (!allow[i][j]) {
                        same = bfs(i, j, same);
                    }
                }
            }

            if (same) {
                System.out.println(day);
                break;
            } else {
                day++;
            }
        }
    }

    private static boolean bfs(int startX, int startY, boolean same) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        List<int[]> union = new ArrayList<>();
        union.add(new int[]{startX, startY});
        allow[startX][startY] = true;
        int people = 0;
        people += maze[startX][startY];

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            int[] directionX = {-1, 1, 0, 0};
            int[] directionY = {0, 0, -1, 1};

            for (int i=0; i<4; i++) {
                int nextX = currentX+directionX[i];
                int nextY = currentY+directionY[i];

                if (nextX<0 || nextX>=n || nextY<0 || nextY>=n) {
                    continue;
                }
                if (allow[nextX][nextY]) {
                    continue;
                }

                int check = Math.abs(maze[currentX][currentY]-maze[nextX][nextY]);
                if (l <= check && check <= r) {
                    if (maze[currentX][currentY] != maze[nextX][nextY]) {
                        same = false;
                        queue.add(new int[]{nextX, nextY});
                        union.add(new int[]{nextX, nextY});
                        allow[nextX][nextY] = true;
                        people += maze[nextX][nextY];
                    }
                }
            }
        }

        if (union.size() > 1) {
            int newPeople = people / union.size();
            for (int[] country : union) {
                maze[country[0]][country[1]] = newPeople;
            }
        }
        return same;
    }
}
