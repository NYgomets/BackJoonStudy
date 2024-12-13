import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] path;
    static String[][] maze;
    static boolean[][] visited;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new String[n][m];
        for (int i=0; i<n; i++) {
            String string = br.readLine();
            for (int j=0; j<m; j++) {
                maze[i][j] = string.substring(j, j+1);
            }
        }
        visited = new boolean[n][m];
        path = new int[n][m];
        int count = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!visited[i][j]) {
                    path[i][j] = count;
                    bfs(i, j, count);
                }
                count++;
            }
        }

        System.out.println(result);
    }

    private static void bfs(int startX, int startY, int count) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, count});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];
            int currentC = poll[2];

            int nextX = -1;
            int nextY = -1;

            if (maze[currentX][currentY].equals("D")) {
                nextX = currentX+1;
                nextY = currentY;
            } else if (maze[currentX][currentY].equals("U")) {
                nextX = currentX-1;
                nextY = currentY;
            } else if (maze[currentX][currentY].equals("R")) {
                nextX = currentX;
                nextY = currentY+1;
            } else {
                nextX = currentX;
                nextY = currentY-1;
            }

            if (!visited[nextX][nextY]) {
                path[nextX][nextY] = count;
                visited[nextX][nextY] = true;
                queue.add(new int[]{nextX, nextY, currentC});
            } else {
                if (path[nextX][nextY] == count) {
                    result++;
                }
            }
        }
    }
}
