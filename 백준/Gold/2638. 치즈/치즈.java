import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] maze;
    static boolean[][] checked;
    static boolean[][] visited;
    static boolean[][] counted;
    static int[] directionX = {-1, 1, 0, 0};
    static int[] directionY = {0, 0, -1, 1};
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

        while (true) {
            checked = new boolean[n][m];
            checkCheese(0, 0);

            visited = new boolean[n][m];
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (!visited[i][j] && maze[i][j] == 1) {
                        meltCheese(i, j);
                    }
                }
            }

            result++;
            boolean allZero = true;
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (maze[i][j] != 0) {
                        allZero = false;
                        break;
                    }
                }
            }

            if (allZero) {
                break;
            }
        }

        System.out.println(result);
    }

    private static void meltCheese(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        visited[startX][startY] = true;
        queue.add(new int[]{startX, startY});
        int count = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            for (int i=0; i<4; i++) {
                int nextX = currentX+directionX[i];
                int nextY = currentY+directionY[i];

                if (nextX<0 || nextX>=n || nextY<0 || nextY>=m) {
                    continue;
                }
                if (visited[nextX][nextY]) {
                    continue;
                }

                if (maze[nextX][nextY] == 0 && checked[nextX][nextY]) {
                    count++;
                }
            }

            if (count>=2) {
                maze[startX][startY] = 0;
            }
        }
    }

    private static void checkCheese(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        checked[startX][startY] = true;
        queue.add(new int[]{startX, startY});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            for (int i=0; i<4; i++) {
                int nextX = currentX+directionX[i];
                int nextY = currentY+directionY[i];

                if (nextX<0 || nextX>=n || nextY<0 || nextY>=m) {
                    continue;
                }
                if (checked[nextX][nextY]) {
                    continue;
                }

                if (maze[nextX][nextY] == 0) {
                    checked[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
    }
}
