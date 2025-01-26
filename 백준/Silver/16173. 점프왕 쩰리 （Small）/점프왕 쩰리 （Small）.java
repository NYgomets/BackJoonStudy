import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] maze;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n];
        maze = new int[n][n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (bfs(0, 0, maze[0][0])>0) {
            System.out.println("HaruHaru");
        } else {
            System.out.println("Hing");
        }
    }

    private static int bfs(int x, int y, int jump) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, jump});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];
            int currentJump = poll[2];

            if (currentX==n-1 && currentY==n-1) {
                return 1;
            }
            if (visited[currentX][currentY]) {
                continue;
            }
            visited[currentX][currentY] = true;

            jumpX(currentX, currentJump, currentY, queue);
            jumpY(currentX, currentJump, currentY, queue);
        }

        return -1;
    }

    private static void jumpY(int currentX, int currentJump, int currentY, Queue<int[]> queue) {
        int nextX = currentX;
        int nextY = currentY+currentJump;
        if (nextX>=n || nextY>=n) {
            return;
        }
        queue.add(new int[]{nextX, nextY, maze[nextX][nextY]});
    }

    private static void jumpX(int currentX, int currentJump, int currentY, Queue<int[]> queue) {
        int nextX = currentX + currentJump;
        int nextY = currentY;
        if (nextX>=n || nextY>=n) {
            return;
        }
        queue.add(new int[]{nextX, nextY, maze[nextX][nextY]});
    }
}
