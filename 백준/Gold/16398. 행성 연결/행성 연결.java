import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static List<Node> edgeList;
    static class Node {
        int start;
        int end;
        int weight;

        public Node(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getWeight() {
            return weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        for (int i=1; i<=n; i++) {
            arr[i] = i;
        }

        edgeList = new ArrayList<>();
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int k=0; k<=i; k++) {
                int trash = Integer.parseInt(st.nextToken());
            }
            for (int j=i+1; j<n; j++) {
                int weight = Integer.parseInt(st.nextToken());
                edgeList.add(new Node(i, j, weight));
            }
        }

        edgeList.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });

        long result = 0;
        int edgeCount = 0;
        for (Node node : edgeList) {
            int start = node.getStart();
            int end = node.getEnd();

            if (find(start) == find(end)) {
                continue;
            }

            edgeCount++;
            union(start, end);
            result += node.getWeight();
            if (edgeCount == n-1) {
                break;
            }
        }

        System.out.println(result);
    }

    public static void union(int a, int b) {
        int first = find(a);
        int second = find(b);

        if (first != second) {
            if (first > second) {
                arr[first] = second;
            } else {
                arr[second] = first;
            }
        }
    }

    public static int find(int a) {
        if (arr[a] != a) {
            arr[a] = find(arr[a]);
        }

        return arr[a];
    }
}
