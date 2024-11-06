import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] maze;
    static boolean[][] visitedArr;
    static Queue<Node> queue;
    static int result;
    static class Node {
        int x;
        int y;
        int day;
        public Node(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getDay() {
            return day;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visitedArr = new boolean[m][n];
        queue = new LinkedList<>();

        maze = new int[m][n];
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
                if (maze[i][j] == 1) {
                    queue.offer(new Node(i, j, 0));
                }
            }
        }

        bfs();

        if (!check()) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static boolean check() {
        boolean mature = true;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (maze[i][j] == 0) {
                    mature = false;
                    return mature;
                }
            }
        }
        return mature;
    }

    private static void bfs() {
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int currentX = poll.getX();
            int currentY = poll.getY();
            int currentDay = poll.getDay();
            visitedArr[currentX][currentY] = true;

            int[] directionX = {-1, 1, 0, 0};
            int[] directionY = {0, 0, -1, 1};

            for (int i=0; i<4; i++) {
                int nextX = currentX + directionX[i];
                int nextY = currentY + directionY[i];

                if (nextX >= 0 && nextX < m && nextY >=0 && nextY <n){
                    if (!visitedArr[nextX][nextY] && maze[nextX][nextY] == 0) {
                        int nextDay = currentDay+1;
                        result = nextDay;
                        maze[nextX][nextY] = 1;
                        visitedArr[nextX][nextY] = true;
                        queue.offer(new Node(nextX, nextY, nextDay));
                    }
                }
            }
        }
    }
}