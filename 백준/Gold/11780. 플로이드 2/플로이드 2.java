import java.beans.PropertyEditorSupport;
import java.io.*;
import java.util.*;

public class Main {
    static int n; // 노드 수
    static int m; // 간선 수
    static long[][] shortestArr;
    static long INF = Integer.MAX_VALUE;
    static int[][] path;
    static StringBuilder sb = new StringBuilder();
    static int city;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        path = new int[n+1][n+1];
        shortestArr = new long[n+1][n+1];
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (i==j) {
                    shortestArr[i][j] = 0;
                } else {
                    shortestArr[i][j] = INF;
                }
                path[i][j] = j;
            }
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (shortestArr[a][b] > c) {
                shortestArr[a][b] = c;
                path[a][b] = b;
            }
        }

        floyd();

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (shortestArr[i][j] == 0 || shortestArr[i][j] == INF) {
                    System.out.print(0 + " ");
                } else {
                    System.out.print(shortestArr[i][j] + " ");
                }
            }
            System.out.println();
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (shortestArr[i][j] == 0 || shortestArr[i][j] == INF) {
                    System.out.println(0);
                } else {
                    city = 2;
                    printPath(i, j);
                    System.out.print(city + " " + sb);
                    System.out.println();
                    sb.setLength(0);
                }
            }
        }
    }

    private static void printPath(int start, int end) {
        if (path[start][end] == end) {
            sb.append(start).append(" ").append(end);

        } else if (path[start][end] != end) {
            ++city;
            sb.append(start).append(" ");
            printPath(path[start][end], end);
        }
    }

    private static void floyd() {
        for (int k=1; k<=n; k++) {
            for (int s=1; s<=n; s++) {
                for (int e=1; e<=n; e++) {
                    if (shortestArr[s][e] > shortestArr[s][k] + shortestArr[k][e]) {
                        shortestArr[s][e] = shortestArr[s][k] + shortestArr[k][e];
                        path[s][e] = path[s][k];
                    }
                }
            }
        }
    }
}