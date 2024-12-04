import java.io.*;
import java.util.*;

public class Main {
    static int v;
    static int result = 0;
    static int cost;
    static List<Node>[] adjList;
    static boolean[] visited;
    static class Node {
        int node;
        int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        public int getNode() {
            return node;
        }

        public int getWeight() {
            return weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        v = Integer.parseInt(br.readLine());
        adjList = new ArrayList[v+1];
        for (int i=1; i<=v; i++) {
            adjList[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i=0; i<v-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adjList[a].add(new Node(b, c));
            adjList[b].add(new Node(a, c));
        }

        for (int i=1; i<=v; i++) {
            visited = new boolean[v+1];
            cost = 0;
            dfs(i, 0);
            if (result < cost) {
                result = cost;
            }
        }

        System.out.println(result);
    }

    private static void dfs(int start, int currentCost) {
        visited[start] = true;
        cost = Math.max(cost, currentCost);

        for (Node node : adjList[start]) {
            if (!visited[node.getNode()]) {
                dfs(node.getNode(), currentCost+ node.getWeight());
            }
        }
    }
}