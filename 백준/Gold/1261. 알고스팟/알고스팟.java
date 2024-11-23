import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] maze;
    static boolean[][] visitedArr;
    static class Node {
        int start;
        int end;
        int count;

        public Node(int start, int end, int count) {
            this.start = start;
            this.end = end;
            this.count = count;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getCount() {
            return count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 열
        m = Integer.parseInt(st.nextToken()); // 행
        maze = new int[m][n];
        visitedArr = new boolean[m][n];
        for (int i=0; i<m; i++) {
            String string = br.readLine();
            for (int j=0; j<n; j++) {
                maze[i][j] = Integer.parseInt(string.substring(j, j+1));
            }
        }

        int result = dikstra(0, 0);
        System.out.println(result);
    }

    private static int dikstra(int startX, int startY) {
        Queue<Node> queue = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1.getCount(), o2.getCount())));
        visitedArr[0][0] = true;
        queue.offer(new Node(0, 0, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int currentX = poll.getStart();
            int currentY = poll.getEnd();
            int count = poll.getCount();

            if (currentX == m-1 && currentY == n-1) {
                return count;
            }

            int[] directionX = {-1, 1, 0, 0};
            int[] directionY = {0, 0, -1, 1};

            for (int i=0; i<4; i++) {
                int nextX = currentX + directionX[i];
                int nextY = currentY + directionY[i];

                if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                    continue;
                }

                if (maze[nextX][nextY] == 0 && !visitedArr[nextX][nextY]) {
                    visitedArr[nextX][nextY] = true;
                    queue.offer(new Node(nextX, nextY, count));
                } else if (maze[nextX][nextY] == 1 && !visitedArr[nextX][nextY]) {
                    visitedArr[nextX][nextY] = true;
                    queue.offer(new Node(nextX, nextY, count+1));
                }
            }
        }
        return -1;
    }
}
