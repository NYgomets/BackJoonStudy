import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static Character[][] maze;
    static boolean[][] visited;
    static int[] directionX = {-1, 0, 1, 0};
    static int[] directionY = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        maze = new Character[n][n];

        for (int i=0; i<n; i++) {
            String string = br.readLine();
            for (int j=0; j<n; j++) {
                char c = string.charAt(j);
                maze[i][j] = c;
            }
        }

        visited = new boolean[n][n];
        int result1 = check(false);
        visited = new boolean[n][n];
        int result2 = check(true);

        System.out.println(result1 + " " + result2);
    }

    private static int check(boolean state) {
        int result = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (!visited[i][j]) {
                    result++;
                    bfs(i, j, maze[i][j], state);
                }
            }
        }
        return result;
    }

    private static void bfs(int startX, int startY, Character check, boolean state) {
        Queue<int[]> queue = new LinkedList<>();
        visited[startX][startY] = true;
        queue.add(new int[]{startX, startY});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            for (int i=0; i<4; i++) {
                int nextX = currentX+directionX[i];
                int nextY = currentY+directionY[i];

                if (nextX<0 || nextX>=n) {
                    continue;
                }
                if (nextY<0 || nextY>=n) {
                    continue;
                }

                if (!state) {
                    if (maze[nextX][nextY] == check && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY});
                    }
                } else {
                    if (check == 'R' || check == 'G') {
                        if ((maze[nextX][nextY] == 'R' || maze[nextX][nextY] == 'G') && !visited[nextX][nextY]) {
                            visited[nextX][nextY] = true;
                            queue.add(new int[]{nextX, nextY});
                        }
                    } else {
                        if (maze[nextX][nextY] == check && !visited[nextX][nextY]) {
                            visited[nextX][nextY] = true;
                            queue.add(new int[]{nextX, nextY});
                        }
                    }
                }
            }
        }
    }
}