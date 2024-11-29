import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
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

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (maze[i][j].equals("L")) {
                    int check = bfs(i, j);
                    if (result < check) {
                        result = check;
                    }
                }
            }
        }
        System.out.println(result);
    }

    private static int bfs(int startX, int startY) {
        visited = new boolean[n][m];
        int check = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];
            int count = poll[2];
            if (check < count) {
                check = count;
            }

            int[] directionX = {-1, 1, 0, 0};
            int[] directionY = {0, 0, -1, 1};

            for (int i=0; i<4; i++) {
                int nextX = currentX + directionX[i];
                int nextY = currentY + directionY[i];

                if (nextX < 0 || nextX>=n || nextY<0 || nextY>=m) {
                    continue;
                }

                if (maze[nextX][nextY].equals("L") && !visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY, count+1});
                }
            }
        }
        return check;
    }
}
