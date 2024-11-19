import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        for (int i=1; i<=n; i++) {
            arr[i] = i;
        }
        edgeList = new ArrayList<>();
        long total = 0;
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            total += c;
            edgeList.add(new Node(a, b, c));
        }

        edgeList.sort(((o1, o2) -> o1.getWeight() - o2.getWeight()));

        long result = 0;
        int edgeCount = 0;
        for (Node node : edgeList) {
            int start = node.getStart();
            int end = node.getEnd();

            if (find(start) == find(end)) {
                continue;
            }

            edgeCount++;
            result+= node.getWeight();
            union(start, end);

            if (edgeCount == n-1) {
                break;
            }
        }

        if (edgeCount != n-1) {
            System.out.println(-1);
        } else {
            System.out.println(total - result);
        }
    }

    private static void union(int a, int b) {
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
    private static int find(int a) {
        if (arr[a] != a) {
            arr[a] = find(arr[a]);
        }

        return arr[a];
    }
}
