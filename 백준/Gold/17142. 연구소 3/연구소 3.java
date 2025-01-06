import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static List<int[]> list = new ArrayList<>();
    static int[][] maze;
    static int[][] arr;
    static boolean[][] visited;
    static int result = Integer.MAX_VALUE;
    static int space = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new int[n][n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
                if (maze[i][j] == 2) {
                    list.add(new int[]{i,j});
                } else if (maze[i][j] == 0) {
                    space++;
                }
            }
        }

        List<int[]> select = new ArrayList<>();
        dfs(0, select);

        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }

    private static void dfs(int start, List<int[]> select) {
        if (select.size() == m) {
            bfs(select);
            minTime();
            return;
        }

        for (int i=start; i<list.size(); i++) {
            select.add(list.get(i));
            dfs(i+1, select);
            select.remove(select.size()-1);
        }
    }

    private static void minTime() {
        int max = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (!visited[i][j] && maze[i][j]!=1 && maze[i][j]!=2) {
                    return;
                }
                max = Math.max(max, arr[i][j]);
            }
        }

        result = Math.min(result, max);
    }

    private static void bfs(List<int[]> select) {
        visited = new boolean[n][n];
        arr = new int[n][n];

        int copySpace = space;
        Queue<int[]> queue = new LinkedList<>();
        for (int[] virus : select) {
            int x = virus[0];
            int y = virus[1];
            arr[x][y] = 0;
            visited[x][y] = true;
            queue.add(new int[]{x, y});
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];

            int[] directionX = {-1, 1, 0, 0};
            int[] directionY = {0, 0, -1, 1};
            for (int i=0; i<4; i++) {
                int nextX = currentX+directionX[i];
                int nextY = currentY+directionY[i];

                if (nextX<0||nextX>=n||nextY<0||nextY>=n) {
                    continue;
                }
                if (visited[nextX][nextY]) {
                    continue;
                }

                if (maze[nextX][nextY] == 0) {
                    arr[nextX][nextY] = arr[currentX][currentY]+1;
                    visited[nextX][nextY] = true;
                    copySpace--;
                    queue.add(new int[]{nextX, nextY});
                } else if (maze[nextX][nextY] == 2) {
                    arr[nextX][nextY] = arr[currentX][currentY]+1;
                    visited[nextX][nextY] = true;
                    queue.add(new int[]{nextX, nextY});
                }

                if (copySpace == 0) {
                    return;
                }
            }
        }
    }
}