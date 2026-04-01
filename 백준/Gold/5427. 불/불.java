import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static String[][] maze;
    static boolean[][] visited;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int n;
    static int m;
    static int pStartX;
    static int pStartY;
    static Queue<int[]> fire;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int z=0; z<t; z++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            fire = new ArrayDeque<>();
            visited = new boolean[m][n];
            maze = new String[m][n];
            for (int i=0; i<m; i++) {
                String[] split = br.readLine().split("");
                for (int j=0; j<n; j++) {
                    maze[i][j] = split[j];
                    if (split[j].equals("@")) {
                        pStartY = i;
                        pStartX = j;
                    } else if (split[j].equals("*")) {
                        fire.add(new int[]{i,j});
                    }
                }
            }

            int result = bfs();
            if (result == -1) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(result);
            }
        }
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{pStartY, pStartX, 0});
        int result = -1;

        while (!queue.isEmpty()) {
            fireBfs();
            int size = queue.size();
            for (int z = 0; z < size; z++) {
                int[] poll = queue.poll();
                int currentY = poll[0];
                int currentX = poll[1];
                int count = poll[2];

                for (int i=0; i<4; i++) {
                    int nextY = currentY + dy[i];
                    int nextX = currentX + dx[i];

                    if (nextY<0 || nextY>=m || nextX<0 || nextX>=n) {
                        return count+1;
                    }
                    if (visited[nextY][nextX]) {
                        continue;
                    }
                    if (maze[nextY][nextX].equals("#")) {
                        continue;
                    }

                    visited[nextY][nextX] = true;
                    queue.add(new int[]{nextY, nextX, count+1});
                }
            }
        }

        return result;
    }

    private static void fireBfs() {
        int size = fire.size();
        for (int j=0; j<size; j++) {
            int[] poll = fire.poll();
            int currentY = poll[0];
            int currentX = poll[1];
            visited[currentY][currentX] = true;

            for (int i=0; i<4; i++) {
                int nextY = currentY + dy[i];
                int nextX = currentX + dx[i];

                if (nextY<0 || nextY>=m || nextX<0 || nextX>=n) {
                    continue;
                }
                if (maze[nextY][nextX].equals("#")) {
                    continue;
                }
                if (visited[nextY][nextX]) {
                    continue;
                }

                fire.add(new int[]{nextY, nextX});
                visited[nextY][nextX] = true;
            }
        }
    }
}