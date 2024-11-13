import java.io.*;
import java.util.*;

public class Main {
    static int n; // 노드 수
    static int m; // 간선 수
    static int k; //벽 부수기 허용된 개수
    static int[][] maze;
    static boolean[][][] visitedArr;
    static class Node {
        int x;
        int y;
        int broke;
        int count;

        public Node(int x, int y, int broke, int count) {
            this.x = x;
            this.y = y;
            this.broke = broke;
            this.count = count;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getBroke() {
            return broke;
        }

        public int getCount() {
            return count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visitedArr = new boolean[n][m][k+1];
        maze = new int[n][m];
        for (int i=0; i<n; i++) {
            String string = br.readLine();
            for (int j=0; j<m; j++) {
                maze[i][j] = Integer.parseInt(string.substring(j, j+1));
            }
        }

        int result = bfs();

        if (result == -1) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static int bfs() {
        Queue<Node> queue = new LinkedList<>();
        visitedArr[0][0][0] = true;
        queue.offer(new Node(0, 0, 0, 1));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int currentX = poll.getX();
            int currentY = poll.getY();
            int broke = poll.getBroke();
            int count = poll.getCount();

            if (currentX == n-1 && currentY == m-1) {
                return count;
            }

            int[] directionX = {-1, 1, 0, 0};
            int[] directionY = {0, 0, -1, 1};

            for (int i=0; i<4; i++) {
                int nextX = currentX + directionX[i];
                int nextY = currentY + directionY[i];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
                    continue;
                }

                if (maze[nextX][nextY] == 1 && broke < k && !visitedArr[nextX][nextY][broke+1]) {
                    visitedArr[nextX][nextY][broke+1] = true;
                    queue.offer(new Node(nextX, nextY, broke+1, count+1));
                } else if (maze[nextX][nextY] == 0 && !visitedArr[nextX][nextY][broke]) {
                    visitedArr[nextX][nextY][broke] = true;
                    queue.offer(new Node(nextX, nextY, broke, count+1));
                }
            }
        }
        return -1;
    }
}