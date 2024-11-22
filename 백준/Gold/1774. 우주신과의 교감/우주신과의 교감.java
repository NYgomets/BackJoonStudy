import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static Map<Node, Node> parentMap = new HashMap<>();
    static Node[] nodes;
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
    static List<Edge> edgeList;
    static class Edge {
        Node first;
        Node second;
        double weight;

        public Edge(Node first, Node second, double weight) {
            this.first = first;
            this.second = second;
            this.weight = weight;
        }

        public Node getFirst() {
            return first;
        }

        public Node getSecond() {
            return second;
        }

        public double getWeight() {
            return weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nodes = new Node[n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(a, b);
            parentMap.put(nodes[i], nodes[i]);
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(nodes[a-1], nodes[b-1]);
        }

        edgeList = new ArrayList<>();
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                double weight = cal(nodes[i], nodes[j]);
                edgeList.add(new Edge(nodes[i], nodes[j], weight));
            }
        }

        edgeList.sort(((o1, o2) -> Double.compare(o1.getWeight(), o2.getWeight())));

        double result = 0;
        for (Edge edge : edgeList) {
            Node start = edge.getFirst();
            Node end = edge.getSecond();

            if (find(start) == find(end)) {
                continue;
            }

            result += edge.getWeight();
            union(start, end);
        }

        System.out.printf("%.2f\n", result);
    }

    private static void union(Node start, Node end) {
        Node first = find(start);
        Node second = find(end);

        if (first != second) {
            parentMap.put(first, second);
        }
    }

    private static Node find(Node start) {
        if (parentMap.get(start) != start) {
            parentMap.put(start, find(parentMap.get(start)));
        }

        return parentMap.get(start);
    }

    private static double cal(Node start, Node end) {
        return Math.sqrt(Math.pow(end.getX()- start.getX(), 2) + Math.pow(end.getY()- start.getY(), 2));
    }
}
