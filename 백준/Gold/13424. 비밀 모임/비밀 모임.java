import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int k;
    static long[][] shortest;
    static long[] position;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int l=0; l<t; l++) {
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
                shortest[b][a] = c;
            }

            floyd();

            position = new long[n+1];
            k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<k; i++) {
                int a = Integer.parseInt(st.nextToken());
                cal(a);
            }

            long check = Integer.MAX_VALUE;
            int result = 0;
            for (int i=1; i<=n; i++) {
                if (check > position[i]) {
                    check = position[i];
                    result = i;
                }
            }
            System.out.println(result);
        }
    }

    private static void cal(int friend) {
        for (int i=1; i<=n; i++) {
            position[i] += shortest[friend][i];
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
