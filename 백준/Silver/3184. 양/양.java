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
        maze = new String[n][m];
        for (int i=0; i<n; i++) {
            String string = br.readLine();
            for (int j=0; j<m; j++) {
                maze[i][j] = string.substring(j, j+1);
            }
        }

        int sheepCount = 0;
        int wolfCount = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!maze[i][j].equals("#") && !visited[i][j]) {
                    int[] result = bfs(i, j);
                    sheepCount += result[0];
                    wolfCount += result[1];
                }
            }
        }

        System.out.println(sheepCount + " " + wolfCount);
    }

    private static int[] bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        int sheep = 0;
        int wolf = 0;
        if (maze[x][y].equals("o")) {
            sheep++;
        }
        if (maze[x][y].equals("v")) {
            wolf++;
        }

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

                if (!maze[nextX][nextY].equals("#")) {
                    visited[nextX][nextY] = true;
                    if (maze[nextX][nextY].equals("o")) {
                        sheep++;
                    }
                    if (maze[nextX][nextY].equals("v")) {
                        wolf++;
                    }
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }

        if (sheep > wolf) {
            return new int[]{sheep, 0};
        } else {
            return new int[]{0, wolf};
        }
    }
}