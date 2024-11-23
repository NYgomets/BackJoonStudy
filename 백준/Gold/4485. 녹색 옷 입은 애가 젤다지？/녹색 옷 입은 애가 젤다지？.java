import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int count = 0;
    static int[][] maze;
    static boolean[][] visitedArr;
    static class Node {
        int start;
        int end;
        int weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getWeight() {
            return weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            count++;
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                return;
            }
            maze = new int[n][n];
            for (int i=0; i<n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j=0; j<n; j++) {
                    maze[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            visitedArr = new boolean[n][n];

            int result = dikstra(0, 0);

            System.out.println("Problem " + count + ": " + result);
        }
    }

    private static int dikstra(int startX, int startY) {
        Queue<Node> queue = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.getWeight(), o2.getWeight())));
        queue.offer(new Node(0, 0, maze[startX][startY]));
        visitedArr[startX][startY] = true;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int currentX = poll.getStart();
            int currentY = poll.getEnd();
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

                if (!visitedArr[nextX][nextY]) {
                    visitedArr[nextX][nextY] = true;
                    queue.offer(new Node(nextX, nextY, maze[nextX][nextY]+weight));
                }
            }
        }
        return -1;
    }
}
