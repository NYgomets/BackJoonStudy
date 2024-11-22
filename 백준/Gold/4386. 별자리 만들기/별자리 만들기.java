import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Map<Node, Node> parentMap = new HashMap<>();
    static Node[] nodes;
    static class Node {
        double x;
        double y;

        public Node(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }
    }
    static List<Edge> edgeList;
    static class Edge {
        Node start;
        Node end;
        double weight;

        public Edge(Node start, Node end, double weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public Node getStart() {
            return start;
        }

        public Node getEnd() {
            return end;
        }

        public double getWeight() {
            return weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        edgeList = new ArrayList<>();
        nodes = new Node[n];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double a = Double.parseDouble(st.nextToken());
            double b = Double.parseDouble(st.nextToken());
            nodes[i] = new Node(a, b);
            parentMap.put(nodes[i], nodes[i]);
        }

        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                double weight = cal(nodes[i], nodes[j]);
                edgeList.add(new Edge(nodes[i], nodes[j], weight));
            }
        }

        edgeList.sort((o1, o2) -> Double.compare(o1.getWeight(), o2.getWeight()));

        double result = 0;
        for (Edge edge : edgeList) {
            Node start = edge.getStart();
            Node end = edge.getEnd();

            if (find(start) == find(end)) {
                continue;
            }

            union(start, end);
            result += edge.getWeight();
        }

        System.out.println(result);
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

    private static double cal(Node first, Node second) {
        return Math.sqrt(Math.pow(second.getX() - first.getX(), 2) + Math.pow(second.getY() - first.getY(), 2));
    }
}
