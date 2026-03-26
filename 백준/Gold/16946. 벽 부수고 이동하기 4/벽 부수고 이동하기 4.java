import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] group;
    static int[] groupSize = new int[1000001];
    static int[][] maze;
    static boolean[][] visited;
    static int [] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static Map<int[][], int[]> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n =  Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        group = new int[n][m];
        visited = new boolean[n][m];
        maze = new int[n][m];
        for (int i=0; i<n; i++) {
            String[] split = br.readLine().split("");
            for (int j=0; j<m; j++) {
                maze[i][j] = Integer.parseInt(split[j]);
            }
        }

        int groupId = 1;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (!visited[i][j] && maze[i][j] == 0) {
                    int size = bfs(j, i, groupId);
                    groupSize[groupId] = size;
                    groupId++;
                }
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (maze[i][j] == 0) {
                    sb.append(0);
                } else {
                    int num = check(j, i);
                    sb.append(num%10);
                }
            }
            sb.append("\n");
        }


        System.out.println(sb.toString());
    }

    private static int check(int startX, int startY) {
        int size = 1;
        Set<Integer> set = new HashSet<>();

        for (int i=0; i<4; i++) {
            int nextX = startX + dx[i];
            int nextY = startY + dy[i];

            if (nextX<0 || nextX>=m || nextY<0 || nextY>=n) {
                continue;
            }
            if (maze[nextY][nextX] == 1) {
                continue;
            }

            if (!set.contains(group[nextY][nextX])) {
                set.add(group[nextY][nextX]);
                size += groupSize[group[nextY][nextX]];
            }
        }

        return size;
    }

    private static int bfs(int startX, int startY, int groupId) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {startX, startY});
        int size = 1;
        group[startY][startX] = groupId;
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curX = poll[0];
            int curY = poll[1];

            for (int i=0; i<4; i++) {
                int newX = curX + dx[i];
                int newY = curY + dy[i];

                if (newX<0 || newX>=m || newY<0 || newY>=n) {
                    continue;
                }
                if (visited[newY][newX]) {
                    continue;
                }
                if (maze[newY][newX] == 1) {
                    continue;
                }

                size++;
                group[newY][newX] = groupId;
                visited[newY][newX] = true;
                queue.add(new int[] {newX, newY});
            }
        }

        return size;
    }
}