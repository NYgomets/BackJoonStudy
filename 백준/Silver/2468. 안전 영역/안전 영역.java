import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] maze;
    static boolean[][] visitedArr;
    static int max = 0;
    static int min = Integer.MAX_VALUE;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        maze = new int[n][n];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                int length = Integer.parseInt(st.nextToken());
                maze[i][j] = length;
                if (max < length) {
                    max = length;
                }
                if (min > length) {
                    min = length;
                }
            }
        }

        for (int i=min; i<=max; i++) {
            int check = check(i);
            if (count < check) {
                count = check;
            }
        }

        if (count == 0) {
            System.out.println(1);
        } else {
            System.out.println(count);
        }
     }

    private static int check(int length) {
        visitedArr = new boolean[n][n];
        int checkCount = 0;

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (maze[i][j] > length && !visitedArr[i][j]) {
                    bfs(i, j, length);
                    checkCount++;
                }
            }
        }

        return checkCount;
    }

    private static void bfs(int y, int x, int l) {
        Queue<int[]> queue = new LinkedList<>();
        visitedArr[y][x] = true;
        queue.add(new int[]{y, x});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentY = poll[0];
            int currentX = poll[1];

            int[] directionY = {-1, 1, 0, 0};
            int[] directionX = {0, 0, -1, 1};

            for (int i=0; i<4; i++) {
                int nextY = currentY+directionY[i];
                int nextX = currentX+directionX[i];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n) {
                    if (maze[nextY][nextX] > l && !visitedArr[nextY][nextX]) {
                        visitedArr[nextY][nextX] = true;
                        queue.offer(new int[]{nextY, nextX});
                    }
                }
            }
        }
    }
}