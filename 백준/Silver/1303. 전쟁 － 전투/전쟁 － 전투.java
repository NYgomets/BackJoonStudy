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
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        maze = new String[n][m];
        for (int i=0; i<n; i++) {
            String string = br.readLine();
            for (int j=0; j<m; j++) {
                maze[i][j] = string.substring(j, j+1);
            }
        }

        int white = 0;
        int blue = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!visited[i][j]) {
                    if (maze[i][j].equals("W")) {
                        white += (int) Math.pow(bfs(i, j), 2);
                    } else {
                        blue += (int) Math.pow(bfs(i, j), 2);
                    }
                }
            }
        }

        System.out.println(white + " " + blue);
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new int[]{x, y});

        String color = maze[x][y];
        int count = 1;
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

                if (maze[nextX][nextY].equals(color)) {
                    visited[nextX][nextY] = true;
                    count++;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }

        return count;
    }
}