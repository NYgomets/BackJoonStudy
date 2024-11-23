import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] maze;
    static boolean[][] visitedArr;
    static class Node {
        int x;
        int y;
        int weight;

        public Node(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getWeight() {
            return weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visitedArr = new boolean[n][n];
        maze = new int[n][n];
        for (int i=0; i<n; i++) {
            String string = br.readLine();
            for (int j=0; j<n; j++) {
                maze[i][j] = Integer.parseInt(string.substring(j, j+1));
            }
        }

        int result = dikstra(0,0);
        System.out.println(result);
    }

    private static int dikstra(int startX, int startY) {
        Queue<Node> queue = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.getWeight(), o2.getWeight())));
        visitedArr[startX][startY] = true;
        queue.offer(new Node(startX, startY, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int currentX = poll.getX();
            int currentY = poll.getY();
            int weight = poll.getWeight();

            if (currentX == n-1 && currentY == n-1) {
                return weight;
            }

            int[] directionX = {-1, 1, 0, 0};
            int[] directionY = {0, 0, -1, 1};

            for (int i=0; i<4; i++) {
                int nextX = currentX + directionX[i];
                int nextY = currentY + directionY[i];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
                    continue;
                }

                if (!visitedArr[nextX][nextY] && maze[nextX][nextY] == 1) {
                    visitedArr[nextX][nextY] = true;
                    queue.offer(new Node(nextX, nextY, weight));
                } else if (!visitedArr[nextX][nextY] && maze[nextX][nextY] == 0) {
                    visitedArr[nextX][nextY] = true;
                    queue.offer(new Node(nextX, nextY, weight+1));
                }
            }
        }
        return -1;
    }
}
