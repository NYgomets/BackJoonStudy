import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n = 5;
    static int[][] maze;
    static int[] directionX = {-1, 1, 0, 0};
    static int[] directionY = {0, 0, -1, 1};
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        maze = new int[n][n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                StringBuilder sb = new StringBuilder();
                sb.append(maze[i][j]);
                dfs(i, j, sb);
            }
        }
        System.out.println(set.size());
    }

    private static void dfs(int x, int y, StringBuilder sb) {
        if (sb.length() == 6) {
            set.add(Integer.parseInt(sb.toString()));
            return;
        }

        for (int i=0; i<4; i++) {
            int nextX = x+directionX[i];
            int nextY = y+directionY[i];

            if (nextX<0||nextX>=n||nextY<0||nextY>=n) {
                continue;
            }

            sb.append(maze[nextX][nextY]);
            dfs(nextX, nextY, sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}