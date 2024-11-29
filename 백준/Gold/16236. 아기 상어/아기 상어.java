import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] maze;
    static boolean[][] visited;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n][n];
        maze = new int[n][n];
        StringTokenizer st;
        int startX = 0;
        int startY = 0;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                int a = Integer.parseInt(st.nextToken());
                maze[i][j] = a;
                if (a == 9) {
                    startX = i;
                    startY = j;
                    maze[startX][startY] = 0;
                }
            }
        }

        bfs(startX, startY);

        System.out.println(result);
    }

    private static void bfs(int startX, int startY) {
        int[] directionX = {-1, 1, 0, 0};
        int[] directionY = {0, 0, -1, 1};

        int sharkSize = 2;
        int feed = 0;
        int time = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY, time});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<int[]> fish = new ArrayList<>();

            for (int i=0; i<size; i++) {
                int[] poll = queue.poll();
                int currentX = poll[0];
                int currentY = poll[1];
                int t = poll[2];

                for (int j=0; j<4; j++) {
                    int nextX = currentX + directionX[j];
                    int nextY = currentY + directionY[j];

                    if (nextX<0 || nextX>=n || nextY<0 || nextY>=n) {
                        continue;
                    }
                    if (visited[nextX][nextY] || maze[nextX][nextY] > sharkSize) {
                        continue;
                    }

                    if (maze[nextX][nextY] != 0 && maze[nextX][nextY] < sharkSize) {
                        fish.add(new int[]{nextX,nextY,t+1});
                    }
                    queue.add(new int[]{nextX, nextY,t+1});
                    visited[nextX][nextY] = true;
                }
            }

            if (!fish.isEmpty()) {
                fish.sort(((o1, o2) -> {
                    if (o1[2] == o2[2]) {
                        if (o1[0] == o2[0]) {
                            return o1[1]-o2[1];
                        } else {
                            return o1[0]-o2[0];
                        }
                    } else {
                        return o1[2]-o2[2];
                    }
                }));

                int[] first = fish.get(0);
                maze[first[0]][first[1]] = 0;
                result = first[2];
                feed++;

                if (feed == sharkSize) {
                    sharkSize++;
                    feed = 0;
                }

                visited = new boolean[n][n];
                queue.clear();
                queue.add(new int[]{first[0],first[1],first[2]});
                visited[first[0]][first[1]] = true;
            }
        }
    }
}
