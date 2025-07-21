import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] maze;
    static int[] directionX = {-1, 0, 1, 0};
    static int[] directionY = {0, -1, 0, 1};
    static boolean[][] visited;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        maze = new int[n][n];
        visited = new boolean[n][n];
        for (int i=0; i<n; i++) {
            String string = br.readLine();
            for (int j=0; j<n; j++) {
                int num = string.charAt(j) - '0';
                maze[i][j] = num;
            }
        }
        int sum = 0;
        List<Integer> list = new ArrayList<>();

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (maze[i][j] != 0 && !visited[i][j]) {
                    sum++;
                    int num = bfs(i, j);
                    list.add(num);
                }
            }
        }
        Collections.sort(list);

        System.out.println(sum);
        for (int i : list) {
            System.out.println(i);
        }

    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            for (int i=0; i<4; i++) {
                int nextX = currentX+directionX[i];
                int nextY = currentY+directionY[i];

                if (0<=nextX && nextX<n) {
                    if (0<=nextY && nextY<n) {
                        if (maze[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                            visited[nextX][nextY] = true;
                            count++;
                            queue.add(new int[]{nextX, nextY});
                        }
                    }
                }
            }
        }

        return count;
    }
}
