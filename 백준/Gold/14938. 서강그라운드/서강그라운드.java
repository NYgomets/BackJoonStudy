import java.io.*;
import java.util.*;
import java.util.logging.SocketHandler;

public class Main {
    static int n; // 노드 수
    static int m; // 탐색 가능 범위
    static int r; // 간선 수
    static int[] items;
    static long[][] shortestArr;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        items = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        shortestArr = new long[n+1][n+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (i==j) {
                    shortestArr[i][j] = 0;
                } else {
                    shortestArr[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i=0; i<r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            shortestArr[a][b] = l;
            shortestArr[b][a] = l;
        }

        floyd();

        for (int i=1; i<=n; i++) {
            int count = 0;
            for (int j=1; j<=n; j++) {
                if (shortestArr[i][j] <= m) {
                    count += items[j];
                }
            }
            if (result < count) {
                result = count;
            }
        }

        System.out.println(result);
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