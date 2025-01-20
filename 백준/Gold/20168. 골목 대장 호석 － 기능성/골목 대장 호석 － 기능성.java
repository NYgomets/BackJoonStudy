import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int a;
    static int b;
    static int c;
    static List<Node>[] adjList;
    static boolean[] visited;
    static class Node {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
    }
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n+1];
        for (int i=1; i<=n ;i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            adjList[start].add(new Node(end, cost));
            adjList[end].add(new Node(start, cost));
        }

        visited = new boolean[n+1];
        visited[a] = true;
        dfs(a, 0, 0);
        System.out.println(result);
    }

    private static void dfs(int start, int total, int max) {
        if (start == b) {
            result = Math.max(result, max);
        } else if (start > b) {
            return;
        }

        for (Node nodes : adjList[start]) {
            if (!visited[nodes.end] && nodes.weight+total<= c) {
                visited[nodes.end] = true;
                dfs(nodes.end, nodes.weight+total, Math.max(max, nodes.weight));
                visited[nodes.end] = false;
            }
        }
    }
}