import java.io.*;
import java.util.*;

public class Main {
    static int m;
    static int n;
    static int k;
    static int area;
    static boolean[][] maze;
    static boolean[][] visited;
    static int[] directionX = {-1, 1, 0, 0};
    static int[] directionY = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        maze = new boolean[m][n];
        for (int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int leftY = Integer.parseInt(st.nextToken());
            int leftX = Integer.parseInt(st.nextToken());
            int rightY = Integer.parseInt(st.nextToken());
            int rightX = Integer.parseInt(st.nextToken());

            for (int j=leftX; j<rightX; j++) {
                for (int k=leftY; k<rightY; k++) {
                    maze[j][k] = true;
                }
            }
        }


        List<Integer> list = new ArrayList<>();
        int count = 0;
        visited = new boolean[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (!visited[i][j] && !maze[i][j]) {
                    area = 1;
                    checkBfs(i, j);
                    count++;
                    list.add(area);
                }
            }
        }

        System.out.println(count);
        Collections.sort(list);
        for (int c : list) {
            System.out.print(c + " ");
        }
    }

    private static void checkBfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        visited[startX][startY] = true;
        queue.add(new int[]{startX, startY});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            for (int i = 0; i < 4; i++) {
                int nextX = currentX + directionX[i];
                int nextY = currentY + directionY[i];

                if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                    continue;
                }
                if (visited[nextX][nextY]) {
                    continue;
                }

                if (!maze[nextX][nextY]) {
                    queue.add(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true;
                    area++;
                }
            }
        }
    }
}