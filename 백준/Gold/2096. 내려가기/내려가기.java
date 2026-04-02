import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] maze;
    static Integer[][] maxDp;
    static Integer[][] minDp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        maze = new int[n][3];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<3; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        maxDp = new Integer[n][3];
        int max = 0;
        for (int i=0; i<3; i++) {
            max = Math.max(max, maxDfs(0, i));
        }

        minDp = new Integer[n][3];
        int min = Integer.MAX_VALUE;
        for (int i=0; i<3; i++) {
            min = Math.min(min, minDfs(0, i));
        }
        System.out.println(max + " " + min);
    }

    private static int minDfs(int depth, int row) {
        if (depth >= n) {
            return 0;
        }

        if (minDp[depth][row] != null) {
            return  minDp[depth][row];
        }

        int min = Integer.MAX_VALUE;
        for (int nextRow=row-1; nextRow<=row+1; nextRow++) {
            if (nextRow>=0 && nextRow<3) {
                min = Math.min(min, maze[depth][row] + minDfs(depth+1, nextRow));
            }
        }

        minDp[depth][row] = min;

        return min;
    }

    private static int maxDfs(int depth, int row) {
        if (depth >= n) {
            return 0;
        }

        if (maxDp[depth][row] != null) {
            return maxDp[depth][row];
        }

        int max = 0;
        for (int nextRow=row-1; nextRow<=row+1; nextRow++) {
            if (nextRow>=0 && nextRow<3) {
                max = Math.max(max, maze[depth][row] + maxDfs(depth+1, nextRow));
            }
        }

        maxDp[depth][row] = max;

        return max;
    }
}