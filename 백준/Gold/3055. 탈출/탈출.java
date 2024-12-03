import java.io.*;
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

        int startX = -1;
        int startY = -1;
        int waterX = -1;
        int waterY = -1;
        for (int i=0; i<n; i++) {
            String string = br.readLine();
            for (int j=0; j<m; j++) {
                String substring = string.substring(j, j + 1);
                maze[i][j] = substring;
                if (substring.equals("S")) {
                    startX = i;
                    startY = j;
                } else if (substring.equals("*")) {
                    if (waterX == -1 && waterY == -1) {
                        waterX = i;
                        waterY = j;
                    }
                }
            }
        }

        bfs(waterX, waterY, startX, startY);
    }

    private static void bfs(int waterX, int waterY, int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        if (waterX != -1 && waterY != -1) {
            queue.add(new int[]{waterX, waterY, -1});
            visited[waterX][waterY] = true;
        }
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

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
                if (maze[nextX][nextY].equals("X")) {
                    continue;
                }
                if (poll[2]>=0 && maze[nextX][nextY].equals("D")) {
                    System.out.println(poll[2]+1);
                    return;
                }

                if (poll[2]>=0 && maze[nextX][nextY].equals(".")) {
                    visited[nextX][nextY] = true;
                    maze[nextX][nextY] = "S";
                    queue.add(new int[]{nextX, nextY, poll[2]+1});
                } else if (poll[2]<0 && maze[nextX][nextY].equals(".")) {
                    visited[nextX][nextY] = true;
                    maze[nextX][nextY] = "*";
                    queue.add(new int[]{nextX, nextY, -1});
                }
            }
        }
        System.out.println("KAKTUS");
    }
}