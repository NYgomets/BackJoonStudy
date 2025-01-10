import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static String[][] maze;
    static boolean[][] visited;
    static int[] directionX = {-1, 1, 0, 0};
    static int[] directionY = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        int startX = -1;
        int startY = -1;
        maze = new String[n][m];
        for (int i=0; i<n; i++) {
            String string = br.readLine();
            for (int j=0; j<m; j++) {
                maze[i][j] = string.substring(j, j+1);
                if (maze[i][j].equals("I")) {
                    startX = i;
                    startY = j;
                }
            }
        }

        int result = bfs(startX, startY);
        if (result != 0) {
            System.out.println(result);
        } else {
            System.out.println("TT");
        }
    }

    private static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        int count = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            for (int i=0; i<4; i++) {
                int nextX = currentX+directionX[i];
                int nextY = currentY+directionY[i];

                if (nextX<0||nextX>=n||nextY<0||nextY>=m) {
                    continue;
                }
                if (visited[nextX][nextY]) {
                    continue;
                }

                if (!maze[nextX][nextY].equals("X")) {
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }

                if (maze[nextX][nextY].equals("P")) {
                    count++;
                }
            }
        }

        return count;
    }
}