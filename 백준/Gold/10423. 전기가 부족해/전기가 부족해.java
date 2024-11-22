import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int k;
    static int[] arr;
    static List<Edge> edgeList;
    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
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
        k = Integer.parseInt(st.nextToken());

        arr = new int[n+1];
        for (int i=1; i<=n; i++) {
            arr[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int firstPlant = Integer.parseInt(st.nextToken());
        for (int i=1; i<k; i++) {
            int secondPlant = Integer.parseInt(st.nextToken());
            union(firstPlant, secondPlant);
            firstPlant = secondPlant;
        }

        edgeList = new ArrayList<>();
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge(a, b, c));
        }

        edgeList.sort(((o1, o2) -> Integer.compare(o1.getWeight(), o2.getWeight())));

        int result = 0;
        for (Edge edge : edgeList) {
            int start = edge.getStart();
            int end = edge.getEnd();

            if (find(start) == find(end)) {
                continue;
            }

            result += edge.getWeight();
            union(start, end);
        }

        System.out.println(result);
    }

    private static void union(int firstPlant, int secondPlant) {
        int first = find(firstPlant);
        int second = find(secondPlant);

        if (first != second) {
            if (first > second) {
                arr[first] = second;
            } else {
                arr[second] = first;
            }
        }
    }

    private static int find(int firstPlant) {
        if (arr[firstPlant] != firstPlant) {
            arr[firstPlant] = find(arr[firstPlant]);
        }

        return arr[firstPlant];
    }
}
