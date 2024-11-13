import java.io.*;
import java.util.*;

public class Main {
    static int n; // 노드 수
    static int m; // 간선 수
    static int[][] maze;
    static boolean[][][] visitedArr;
    static class Node {
        int x;
        int y;
        boolean brokenWall;
        int count;

        public Node(int x, int y, boolean brokenWall, int count) {
            this.x = x;
            this.y = y;
            this.brokenWall = brokenWall;
            this.count = count;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public boolean isBrokenWall() {
            return brokenWall;
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

        visitedArr = new boolean[n][m][2]; //0은 벽을 부수지 않은 상태, 1은 벽을 부순 상태
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
        queue.offer(new Node(0, 0, false, 1));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int currentX = poll.getX();
            int currentY = poll.getY();
            boolean brokenWall = poll.isBrokenWall();
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

                if (brokenWall) {
                    if (!visitedArr[nextX][nextY][1] && maze[nextX][nextY] == 0) {
                        visitedArr[nextX][nextY][1] = true;
                        queue.offer(new Node(nextX, nextY, true, count+1));
                    }
                } else {
                    if (maze[nextX][nextY] == 1) {
                        visitedArr[nextX][nextY][1] = true;
                        queue.offer(new Node(nextX, nextY, true, count+1));
                    } else if (!visitedArr[nextX][nextY][0]) {
                        visitedArr[nextX][nextY][0] = true;
                        queue.offer(new Node(nextX, nextY, false, count+1));
                    }
                }
            }
        }
        return -1;
    }
}