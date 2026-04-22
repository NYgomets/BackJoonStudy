import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static String[][] maze;
    static int[][][] visited;
    static int startY;
    static int startX;
    static int[] dX = {-1, 0, 1, 0};
    static int[] dY = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        boolean find = false;
        int endY = 0;
        int endX = 0;
        maze = new String[n][n];
        for (int i=0; i<n; i++) {
            String s = br.readLine();
            for (int j=0; j<n; j++) {
                maze[i][j] = String.valueOf(s.charAt(j));
                if (maze[i][j].equals("#") && !find) {
                    startY = i;
                    startX = j;
                    find = true;
                } else if (maze[i][j].equals("#") && find) {
                    endY = i;
                    endX = j;
                }
            }
        }

        visited = new int[n][n][4];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                for  (int k=0; k<4; k++) {
                    visited[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        dikstra(startY, startX);

        int result = Integer.MAX_VALUE;
        for (int i=0; i<4; i++) {
            result = Math.min(result, visited[endY][endX][i]);
        }
        System.out.println(result);
    }

    private static void dikstra(int startY, int startX) {
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        for (int i=0; i<4; i++) {
            visited[startY][startX][i] = 0;
            queue.add(new int[]{startY, startX, 0, i});
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curY = poll[0];
            int curX = poll[1];
            int curMirror = poll[2];
            int curPoint = poll[3];

            for (int i=0; i<4; i++) {
                int nextY = curY + dY[i];
                int nextX = curX + dX[i];

                if (nextY<0 || nextY>=n || nextX<0 || nextX>=n) {
                    continue;
                }
                if (maze[nextY][nextX].equals("*")) {
                    continue;
                }

                // 직진만
                if (curPoint == i) {
                    if (visited[nextY][nextX][curPoint] > curMirror) {
                        visited[nextY][nextX][curPoint] = curMirror;
                        queue.add(new int[]{nextY, nextX, visited[nextY][nextX][curPoint], curPoint});
                    }
                }

                // 방향전환
                if (maze[nextY][nextX].equals("!") && curPoint == i) {

                    int left = (curPoint + 3) % 4;
                    int right = (curPoint + 1) % 4;

                    if (visited[nextY][nextX][left] > curMirror + 1) {
                        visited[nextY][nextX][left] = curMirror + 1;
                        queue.add(new int[]{nextY, nextX, visited[nextY][nextX][left], left});
                    }

                    if (visited[nextY][nextX][right] > curMirror + 1) {
                        visited[nextY][nextX][right] = curMirror + 1;
                        queue.add(new int[]{nextY, nextX, visited[nextY][nextX][right], right});
                    }
                }
            }
        }
    }
}