import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static boolean[][] maze;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        maze = new boolean[n][n];

        dfs(0);
        System.out.println(result);
    }

    private static void dfs(int row) {
        if (row==n) {
            result++;
            return;
        }

        for (int col=0; col<n; col++) {
            if (safe(row, col)) {
                maze[row][col] = true;
                dfs(row+1);
                maze[row][col] = false;
            }
        }

    }

    private static boolean safe(int row, int col) {
        for (int i=0; i<n; i++) {
            if (maze[i][col]) {
                return false;
            }
        }

        for (int i=1; row-i>=0&&col-i>=0; i++) {
            if (maze[row-i][col-i]) {
                return false;
            }
        }
        
        for (int i=1; row-i>=0&&col+i<n; i++) {
            if (maze[row-i][col+i]) {
                return false;
            }
        }
        
        return true;
    }
}