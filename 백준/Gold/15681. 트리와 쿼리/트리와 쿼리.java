import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static List<Integer>[] adjList;
    static boolean[] visited;
    static int[] check;
    static int[] subTree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int u = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        check = new int[q];
        subTree = new int[u+1];
        visited = new boolean[u+1];
        adjList = new ArrayList[u + 1];
        for (int i = 1; i <= u; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i=1; i<u; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }

        for (int i=0; i<q; i++) {
            check[i] = Integer.parseInt(br.readLine());
        }

        dfs(v);

        StringBuilder sb = new StringBuilder();
        for (int a : check) {
            sb.append(subTree[a]).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void dfs(int start) {
        visited[start] = true;
        subTree[start] = 1;

        for (int next : adjList[start]) {
            if (!visited[next]) {
                dfs(next);
                subTree[start] += subTree[next];
            }
        }
    }
}