import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int r;
    static List<Integer>[] adjList;
    static boolean[] visitedArr;
    static int[] checkArr;
    static int count = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        checkArr = new int[n+1];
        visitedArr = new boolean[n+1];
        adjList = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList[u].add(v);
            adjList[v].add(u);
        }


        for (int i=1; i<=n; i++) {
            Collections.sort(adjList[i], Collections.reverseOrder());
        }

        dfs(r);

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=n; i++) {
            if (!visitedArr[i]) {
                sb.append(0).append("\n");
            } else {
                sb.append(checkArr[i]).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void dfs(int start) {
        visitedArr[start] = true;
        checkArr[start] = count++;

        for (int next : adjList[start]) {
            if (!visitedArr[next]) {
                dfs(next);
            }
        }
    }
}