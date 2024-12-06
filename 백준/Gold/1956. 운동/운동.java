import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static long[][] shortest;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        shortest = new long[n+1][n+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (i==j) {
                    shortest[i][j] = 0;
                } else {
                    shortest[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            shortest[a][b] = c;
        }

        floyd();

        boolean possible = false;
        long result = Integer.MAX_VALUE;
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (i!=j) {
                    long check = shortest[i][j] + shortest[j][i];
                    if (check < Integer.MAX_VALUE) {
                        possible = true;
                        result = Math.min(result, check);
                    }
                }
            }
        }

        if (possible) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }

    private static void floyd() {
        for (int k=1; k<=n; k++) {
            for (int s=1; s<=n; s++) {
                for (int e=1; e<=n; e++) {
                    if (shortest[s][e] > shortest[s][k] + shortest[k][e]) {
                        shortest[s][e] = shortest[s][k] + shortest[k][e];
                    }
                }
            }
        }
    }
}
