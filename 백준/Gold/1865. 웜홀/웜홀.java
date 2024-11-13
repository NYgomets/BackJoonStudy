import java.io.*;
import java.util.*;

public class Main {
    static int n; // 노드 수
    static int m; // 간선 수
    static int w; // 웜홀 수
    static long[] shortestArr; // 최단거리 배열
    static int[][] edgeList; // 인접리스트
    static int INF = Integer.MAX_VALUE;
    static boolean minus;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int r=0; r<t; r++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            edgeList = new int[(2*m + w) + 1][3];
            shortestArr = new long[n+1];

            /**
             * 도로
             */
            for (int i=1; i<=2*m; i += 2) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                edgeList[i][0] = s;
                edgeList[i][1] = e;
                edgeList[i][2] = c;

                edgeList[i+1][0] = e;
                edgeList[i+1][1] = s;
                edgeList[i+1][2] = c;
            }

            /**
             * 웜홀
             */
            for (int i=(2*m)+1; i<=(2*m)+w; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                edgeList[i][0] = s;
                edgeList[i][1] = e;
                edgeList[i][2] = -c;
            }

            minus = false;
            for (int i=1; i<=n; i++) {
                Arrays.fill(shortestArr, INF);
                shortestArr[i] = 0;

                for (int q=0; q<n-1; q++) {
                    boolean bellman = bellman();
                    if (!bellman) {
                        break;
                    }
                }

                for (int z=1; z<=2*m + w; z++) {
                    if (shortestArr[edgeList[z][0]] != INF && shortestArr[edgeList[z][1]] > shortestArr[edgeList[z][0]] + edgeList[z][2]) {
                        minus = true;
                        break;
                    }
                }

                if (minus) {
                    break;
                }
            }


            if (!minus) {
                sb.append("NO").append("\n");
            } else {
                sb.append("YES").append("\n");
            }
        }
        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    private static boolean bellman() {
        boolean update = false;
        for (int i=1; i<=2*m + w; i++) {
            if (shortestArr[edgeList[i][0]] != INF && shortestArr[edgeList[i][1]] > shortestArr[edgeList[i][0]] + edgeList[i][2]) {
                shortestArr[edgeList[i][1]] = shortestArr[edgeList[i][0]] + edgeList[i][2];
                update = true;
            }
        }
        return update;
    }
}