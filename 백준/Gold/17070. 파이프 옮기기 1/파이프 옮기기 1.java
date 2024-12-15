import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] maze;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        maze = new int[n][n];
        StringTokenizer st;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (maze[n-1][n-1] == 1) {
            System.out.println(0);
            return;
        }
        
        bfs(0,1, 0);

        System.out.println(result);
    }

    private static void bfs(int rightX, int rightY, int type) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{rightX, rightY, type});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];
            int currentType = poll[2];

            if (currentX==n-1 && currentY==n-1) {
                result++;
                continue;
            }

            if (currentType==0) {
                first(currentX, currentY, queue);
                second(currentX, currentY, queue);
            } else if (currentType==1) {
                second(currentX, currentY, queue);
                third(currentX, currentY, queue);
            } else {
                first(currentX, currentY, queue);
                second(currentX, currentY, queue);
                third(currentX, currentY, queue);
            }
        }
    }

    private static void third(int currentX, int currentY, Queue<int[]> queue) {
        int nextX = currentX+1;
        int nextY = currentY;

        if (nextX<n && maze[nextX][nextY]==0) {
            queue.add(new int[]{nextX, nextY, 1});
        }
    }

    private static void second(int currentX, int currentY, Queue<int[]> queue) {
        int nextX = currentX+1;
        int nextY = currentY+1;

        if (nextX<n && nextY<n && maze[nextX][nextY]==0 && maze[currentX][nextY]==0 && maze[nextX][currentY]==0) {
            queue.add(new int[]{nextX, nextY, 2});
        }
    }

    private static void first(int currentX, int currentY, Queue<int[]> queue) {
        int nextX = currentX;
        int nextY = currentY+1;

        if (nextY<n && maze[nextX][nextY]==0) {
            queue.add(new int[]{nextX, nextY, 0});
        }
    }
}
