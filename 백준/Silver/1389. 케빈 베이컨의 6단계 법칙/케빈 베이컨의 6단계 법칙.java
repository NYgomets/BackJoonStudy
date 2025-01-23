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
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            shortest[start][end] = 1;
            shortest[end][start] = 1;
        }

        floyd();

        int result = 0;
        long min = Integer.MAX_VALUE;
        for (int i=1; i<=n; i++) {
            long count = 0;
            for (int j=1; j<=n; j++) {
                if (shortest[i][j] != 0 || shortest[i][j] != Integer.MAX_VALUE) {
                    count+=shortest[i][j];
                }
            }
            if (min > count) {
                min = count;
                result = i;
            }
        }

        System.out.println(result);
    }

    private static void floyd() {
        for (int k=1; k<=n; k++) {
            for (int s=1; s<=n; s++) {
                for (int e=1; e<=n; e++) {
                    shortest[s][e] = Math.min(shortest[s][e], shortest[s][k]+shortest[k][e]);
                }
            }
        }
    }
}
