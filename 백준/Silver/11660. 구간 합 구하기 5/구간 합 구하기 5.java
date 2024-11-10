import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] maze;
    static int[][] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=n; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sum = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                sum[i][j] = sum[i][j-1] + maze[i][j];
            }
        }


        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            calculation(x1, y1, x2, y2);
        }
    }

    private static void calculation(int x1, int y1, int x2, int y2) {
        int result = 0;
        for (int i=x1; i<=x2; i++) {
            result += (sum[i][y2] - sum[i][y1-1]);
        }
        System.out.println(result);
    }
}