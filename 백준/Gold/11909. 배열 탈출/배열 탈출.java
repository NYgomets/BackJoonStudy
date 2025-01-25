import javax.swing.*;
import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] maze;
    static int[][] minCost;
    static int[] directionX = {0, 1};
    static int[ ]directionY = {1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        minCost = new int[n][n];
        maze = new int[n][n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
                minCost[i][j] = Integer.MAX_VALUE;
            }
        }

        System.out.println(bfs(0, 0, 0));
    }

    private static int bfs(int x, int y, int cost) {
        Queue<int[]> queue = new PriorityQueue<>(((o1, o2) -> o1[2]-o2[2]));
        queue.add(new int[]{x, y, 0});
        minCost[x][y] = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];
            int currentCost = poll[2];

            if (currentX == n-1 && currentY == n-1) {
                return currentCost;
            }

            for (int i=0; i<2; i++) {
                int nextX = currentX+directionX[i];
                int nextY = currentY+directionY[i];

                if (nextX>=n || nextY>=n) {
                    continue;
                }

                int newCost = (maze[currentX][currentY] > maze[nextX][nextY]) ? currentCost : currentCost+(maze[nextX][nextY]-maze[currentX][currentY]+1);
                if (minCost[nextX][nextY] <= newCost) {
                    continue;
                }

                minCost[nextX][nextY] = newCost;
                queue.add(new int[]{nextX, nextY, newCost});
            }
        }
        return -1;
    }
}
