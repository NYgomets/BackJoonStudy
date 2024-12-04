import java.io.*;
import java.util.*;

public class Main {
    static int v;
    static int cost = 0;
    static int boost = 0;
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
        for (int i=0; i<v; i++) {
            st = new StringTokenizer(br.readLine());
            int current = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int next = Integer.parseInt(st.nextToken());
                if (next == -1) {
                    break;
                }

                int weight = Integer.parseInt(st.nextToken());
                adjList[current].add(new Node(next, weight));
                adjList[next].add(new Node(current, weight));
            }
        }

        visited = new boolean[v+1];
        nodeDfs(1, 0);
        visited = new boolean[v+1];
        cost = 0;
        dfs(boost, 0);

        System.out.println(cost);
    }

    private static void nodeDfs(int start, int currentCost) {
        visited[start] = true;
        if (cost < currentCost) {
            cost = currentCost;
            boost = start;
        }

        for (Node node : adjList[start]) {
            if (!visited[node.getNode()]) {
                nodeDfs(node.getNode(), currentCost+ node.getWeight());
            }
        }
    }

    private static void dfs(int start, int currentConst) {
        visited[start] = true;
        cost = Math.max(cost, currentConst);

        for (Node node : adjList[start]) {
            if (!visited[node.getNode()]) {
                dfs(node.getNode(), currentConst+ node.getWeight());
            }
        }
    }
}