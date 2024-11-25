import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static long[][] bigger;
    static long[][] lower;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        lower = new long[n+1][n+1];
        bigger = new long[n+1][n+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (i==j) {
                    lower[i][j] = 0;
                    bigger[i][j] = 0;
                } else {
                    lower[i][j] = Integer.MAX_VALUE;
                    bigger[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bigger[a][b] = b;
            lower[b][a] = a;
        }

        floyd(bigger);
        floyd(lower);

        int result = 0;
        for (int i=1; i<=n; i++) {
            int count = n;
            for (int j=1; j<=n; j++) {
                if (bigger[i][j] == Integer.MAX_VALUE && lower[i][j] == Integer.MAX_VALUE) {
                    count--;
                }
            }
            if (count == n) {
                result++;
            }
        }
        System.out.println(result);

    }

    private static void floyd(long[][] arr) {
        for (int k=1; k<=n; k++) {
            for (int s=1; s<=n; s++) {
                for (int e=1; e<=n; e++) {
                    if (arr[s][e] > arr[s][k]+arr[k][e]) {
                        arr[s][e] = arr[s][k]+arr[k][e];
                    }
                }
            }
        }
    }
}
