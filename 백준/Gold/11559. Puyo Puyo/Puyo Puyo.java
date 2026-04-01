import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String[][] maze;
    static boolean[][] visited;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int n = 12;
    static int m = 6;
    static Queue<int[]> checkQueue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        maze = new String[n][m];
        for (int i = 0; i < n; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                maze[i][j] = split[j];
            }
        }

        int count = 0;
        while (true) {
            if (breakBfs()) {
                count++;
                move();
            } else {
                break;
            }
        }

        System.out.println(count);
    }

    private static void move() {
        for (int i=10; i>=0; i--) {
            for (int j=0; j<m; j++) {
                if (!maze[i][j].equals(".")) {
                    bottom(i, j);
                }
            }
        }
    }

    private static void bottom(int startY, int startX) {
        int curY = startY;
        int curX = startX;
        String color = maze[startY][startX];

        while (true) {
            int nextY = curY+1;
            if (nextY >= n) {
                break;
            }
            if (!maze[nextY][curX].equals(".")) {
                break;
            }

            maze[curY][curX] = ".";
            maze[nextY][curX] = color;
            curY =  nextY;
        }
    }

    private static boolean breakBfs() {
        boolean check = false;
        visited = new boolean[n][m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!visited[i][j] && !maze[i][j].equals(".")) {
                    if (checkBfs(i, j)) {
                        check = true;
                        change();
                    }
                }
            }
        }

        return check;
    }

    private static void change() {
        while (!checkQueue.isEmpty()) {
            int[] cur = checkQueue.poll();
            int curY = cur[0];
            int curX = cur[1];
            maze[curY][curX] = ".";
        }
    }

    private static boolean checkBfs(int startY, int startX) {
        Queue<int[]> queue = new LinkedList<>();
        checkQueue = new LinkedList<>();
        String color = maze[startY][startX];
        boolean result = false;
        int count = 1;
        queue.add(new int[] {startY, startX});
        checkQueue.add(new int[] {startY, startX});
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currY = poll[0];
            int currX = poll[1];

            for (int i=0; i<4; i++) {
                int nextY = currY + dy[i];
                int nextX = currX + dx[i];

                if (nextY < 0  || nextY >= n || nextX < 0 || nextX >= m) {
                    continue;
                }
                if (visited[nextY][nextX]) {
                    continue;
                }

                if (color.equals(maze[nextY][nextX])) {
                    count++;
                    visited[nextY][nextX] = true;
                    queue.add(new int[] {nextY, nextX});
                    checkQueue.add(new int[] {nextY, nextX});
                }
            }
        }

        if (count >= 4) {
            result = true;
        }

        return result;
    }
}