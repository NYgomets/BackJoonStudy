import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int l;
    static int x;
    static int y;
    static int goalX;
    static int goalY;
    static boolean[][] visitedArr;
    static class Node {
        int x;
        int y;
        int time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getTime() {
            return time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++) {
            l = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            goalX = Integer.parseInt(st.nextToken());
            goalY = Integer.parseInt(st.nextToken());

            bfs();
        }

    }

    private static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        visitedArr = new boolean[l][l];
        visitedArr[x][y] = true;
        queue.offer(new Node(x, y, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int currentX = node.getX();
            int currentY = node.getY();

            if (currentX == goalX && currentY == goalY) {
                System.out.println(node.getTime());
                return;
            }

            int[] directionX = {-2, -1, 1, 2, -2, -1, 1, 2};
            int[] directionY = {-1, -2, -2, -1, 1, 2, 2, 1};

            for (int i=0; i<8; i++) {
                int nextX = currentX + directionX[i];
                int nextY = currentY + directionY[i];

                if (nextX >= 0 && nextX < l && nextY >= 0 && nextY < l) {
                    if (!visitedArr[nextX][nextY]) {
                        visitedArr[nextX][nextY] = true;
                        queue.offer(new Node(nextX, nextY, node.getTime()+1));
                    }
                }
            }
        }
    }
}