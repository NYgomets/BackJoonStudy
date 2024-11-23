import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static String[][] maze;
    static boolean[][] visitedArr;
    static class Node {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        maze = new String[n][n];
        for (int i=0; i<n; i++) {
            String string = br.readLine();
            for (int j=0; j<n; j++) {
                maze[i][j] = string.substring(j, j+1);
            }
        }

        visitedArr = new boolean[n][n];
        System.out.print(check(false) + " ");
        visitedArr = new boolean[n][n];
        System.out.print(check(true));
    }

    private static int check(boolean state) {
        int area = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (!visitedArr[i][j]) {
                    dikstra(i, j, state);
                    area++;
                }
            }
        }
        return area;
    }

    private static void dikstra(int startX, int startY, boolean state) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startX, startY));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int currentX = poll.getStart();
            int currentY = poll.getEnd();

            if (visitedArr[currentX][currentY]) {
                continue;
            }
            visitedArr[currentX][currentY] = true;

            int[] directionX = {-1, 1, 0, 0};
            int[] directionY = {0, 0, -1, 1};
            for (int i = 0; i < 4; i++) {
                int nextX = currentX + directionX[i];
                int nextY = currentY + directionY[i];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
                    continue;
                }

                if (state) {
                    if (!visitedArr[nextX][nextY]) {
                        if (maze[currentX][currentY].equals(maze[nextX][nextY])) {
                            queue.offer(new Node(nextX, nextY));
                        } else if (maze[currentX][currentY].equals("R") || maze[currentX][currentY].equals("G")) {
                            if (maze[nextX][nextY].equals("R") || maze[nextX][nextY].equals("G")) {
                                queue.offer(new Node(nextX, nextY));
                            }
                        }
                    }
                } else {
                    if (!visitedArr[nextX][nextY]) {
                        if (maze[currentX][currentY].equals(maze[nextX][nextY])) {
                            queue.offer(new Node(nextX, nextY));
                        }
                    }
                }
            }
        }
    }
}
