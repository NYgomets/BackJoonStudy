import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int h;
    static int[][][] maze;
    static boolean[][][] visitedArr;
    static Queue<Node> queue;
    static int result;
    static class Node {
        int x;
        int y;
        int h;
        int day;
        public Node(int h, int y, int x,int day) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.day = day;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getH() {
            return h;
        }

        public int getDay() {
            return day;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //x
        m = Integer.parseInt(st.nextToken()); //y
        h = Integer.parseInt(st.nextToken()); //높이

        visitedArr = new boolean[h][m][n];
        queue = new LinkedList<>();

        maze = new int[h][m][n];
        for (int k=0; k<h; k++){
            for (int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<n; j++) {
                    maze[k][i][j] = Integer.parseInt(st.nextToken());
                    if (maze[k][i][j] == 1) {
                        queue.offer(new Node(k, i, j, 0));
                    }
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
        for (int k=0; k<h; k++){
            for (int i=0; i<m; i++) {
                for (int j=0; j<n; j++) {
                    if (maze[k][i][j] == 0) {
                        mature = false;
                        return mature;
                    }
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
            int currentH = poll.getH();
            int currentDay = poll.getDay();
            visitedArr[currentH][currentY][currentX] = true;

            int[] directionX = {-1, 1, 0, 0, 0, 0};
            int[] directionY = {0, 0, -1, 1, 0 ,0};
            int[] directionH = {0, 0, 0, 0, -1, 1};

            for (int i=0; i<6; i++) {
                int nextX = currentX + directionX[i];
                int nextY = currentY + directionY[i];
                int nextH = currentH + directionH[i];

                if (nextX >= 0 && nextX < n && nextY >=0 && nextY < m && nextH >= 0 && nextH < h){
                    if (!visitedArr[nextH][nextY][nextX] && maze[nextH][nextY][nextX] == 0) {
                        int nextDay = currentDay+1;
                        result = nextDay;
                        maze[nextH][nextY][nextX] = 1;
                        visitedArr[nextH][nextY][nextX] = true;
                        queue.offer(new Node(nextH, nextY, nextX, nextDay));
                    }
                }
            }
        }
    }
}