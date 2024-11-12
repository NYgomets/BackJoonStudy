import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static long[][] shortestArr;
    static long INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        shortestArr = new long[n+1][n+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (i == j) {
                    shortestArr[i][j] = 0;
                } else {
                    shortestArr[i][j] = INF;
                }
            }
        }

        for (int i=0; i<m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (shortestArr[a][b] > c) {
                shortestArr[a][b] = c;
            }
        }

        floyd();

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (shortestArr[i][j] == INF || shortestArr[i][j] == 0) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(shortestArr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static void floyd() {
        for (int k=1; k<=n; k++) {
            for (int s=1; s<=n; s++) {
                for (int e=1; e<=n; e++) {
                    shortestArr[s][e] = Math.min(shortestArr[s][e], shortestArr[s][k] + shortestArr[k][e]);
                }
            }
        }
    }
}