import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] maze;
    static boolean[][] visited;
    static boolean[][] check;
    static boolean[][] air;
    static int[] directionX = {-1, 1, 0, 0};
    static int[] directionY = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new int[n][m];
        int ch = 0;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                int a = Integer.parseInt(st.nextToken());
                maze[i][j] = a;
                if (a == 1) {
                    ch++;
                }
            }
        }

        int last = ch;
        int time = 0;
        while (true) {
            time++;
            air = new boolean[n][m];
            airBfs(0, 0);

            visited = new boolean[n][m];
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (!visited[i][j] && maze[i][j] == 1) {
                        bfs(i, j);
                    }
                }
            }

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

            last = 0;
            check = new boolean[n][m];
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (!check[i][j] && maze[i][j] == 1) {
                        last += count(i, j);
                    }
                }
            }
        }
        System.out.println(time);
        System.out.println(last);
    }

    private static void airBfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        air[startX][startY] = true;
        queue.add(new int[]{startX, startY});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            for (int i=0; i<4; i++) {
                int nextX = currentX + directionX[i];
                int nextY = currentY + directionY[i];

                if (nextX<0 || nextX>=n || nextY<0 || nextY>=m) {
                    continue;
                }
                if (air[nextX][nextY]) {
                    continue;
                }

                if (maze[nextX][nextY] == 0) {
                    air[nextX][nextY] = true;
                    queue.add(new int[]{nextX,nextY});
                }
            }
        }
    }

    private static int count(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        check[startX][startY] = true;
        queue.add(new int[]{startX, startY});
        int cheese = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            for (int i=0; i<4; i++) {
                int nextX = currentX + directionX[i];
                int nextY = currentY + directionY[i];

                if (nextX<0 || nextX>=n || nextY<0 || nextY>=m) {
                    continue;
                }
                if (check[nextX][nextY]) {
                    continue;
                }

                if (maze[nextX][nextY] == 1) {
                    check[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                    cheese++;
                }
            }
        }
        return cheese;
    }

    private static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        visited[startX][startY] = true;
        queue.add(new int[]{startX, startY});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            for (int i=0; i<4; i++) {
                int nextX = currentX + directionX[i];
                int nextY = currentY + directionY[i];

                if (nextX<0 || nextX>=n || nextY<0 || nextY>=m) {
                    continue;
                }
                if (visited[nextX][nextY]) {
                    continue;
                }

                if (maze[nextX][nextY] == 0 && air[nextX][nextY]) {
                    maze[currentX][currentY] = 0;
                    break;
                }
            }
        }
    }
}