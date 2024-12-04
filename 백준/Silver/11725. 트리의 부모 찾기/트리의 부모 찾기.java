import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<Integer>[] adjList;
    static int[] parent;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        adjList = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }

        parent = new int[n+1];
        for (int i=1; i<=n; i++) {
            parent[i] = i;
        }
        visited = new boolean[n+1];

        dfs(1);

        StringBuilder sb = new StringBuilder();
        for (int i=2; i<=n; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int start) {
        visited[start] = true;

        for (int next : adjList[start]) {
            if (!visited[next]) {
                dfs(next);
            } else {
                parent[start] = next;
            }
        }
    }
}