import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] adjList;
    static long[] shortestArr;
    static int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        adjList = new int[m+1][3];
        shortestArr = new long[n+1];
        for (int i=1; i<=n; i++) {
            if (i==1) {
                shortestArr[i] = 0;
            } else {
                shortestArr[i] = INF;
            }
        }
        for (int i=1; i<=m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList[i][0] = a;
            adjList[i][1] = b;
            adjList[i][2] = c;
        }

        for (int i=0; i<n-1; i++) {
            bellman();
        }

        /**
         * 음수싸이클 판별
         */
        boolean minus = false;
        for (int i=1; i<=m; i++) {
            if (shortestArr[adjList[i][0]] != INF && shortestArr[adjList[i][1]] > shortestArr[adjList[i][0]] + adjList[i][2]) {
                minus = true;
                break;
            }
        }

        if (minus) {
            System.out.println("-1");
        } else {
            for (int i=2; i<=n; i++) {
                if (shortestArr[i] == INF) {
                    System.out.println("-1");
                } else {
                    System.out.println(shortestArr[i]);
                }
            }
        }
    }

    private static void bellman() {
        for (int i=1; i<=m; i++) {
            if (shortestArr[adjList[i][0]] != INF && shortestArr[adjList[i][1]] > shortestArr[adjList[i][0]] + adjList[i][2]) {
                shortestArr[adjList[i][1]] = shortestArr[adjList[i][0]] + adjList[i][2];
            }
        }
    }
}