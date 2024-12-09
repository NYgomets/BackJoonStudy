import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static long[][] shortest;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
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

        StringTokenizer st;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            shortest[a][b] = 1;
        }

        floyd();

        for (int i=1; i<=n; i++) {
            int count = 0;
            for (int j=1; j<=n; j++) {
                if (shortest[i][j] == Integer.MAX_VALUE && shortest[j][i] == Integer.MAX_VALUE) {
                    count++;
                }
            }
            System.out.println(count);
        }
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
