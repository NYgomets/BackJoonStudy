import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
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
    }
    static Node[] planet;
    static class Node {
        int idx;
        int x;
        int y;
        int z;

        public Node(int idx, int x, int y, int z) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        for (int i=1; i<=n; i++) {
            arr[i] = i;
        }

        planet = new Node[n];
        StringTokenizer st;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            planet[i] = new Node(i, x, y, z);
        }

        edgeList = new ArrayList<>();
        Arrays.sort(planet, ((o1, o2) -> o1.x-o2.x));
        for (int i=0; i<n-1; i++) {
            int abs = Math.abs(planet[i].x - planet[i + 1].x);
            edgeList.add(new Edge(planet[i].idx, planet[i+1].idx, abs));
        }
        Arrays.sort(planet, ((o1, o2) -> o1.y-o2.y));
        for (int i=0; i<n-1; i++) {
            int abs = Math.abs(planet[i].y - planet[i + 1].y);
            edgeList.add(new Edge(planet[i].idx, planet[i+1].idx, abs));
        }
        Arrays.sort(planet, ((o1, o2) -> o1.z-o2.z));
        for (int i=0; i<n-1; i++) {
            int abs = Math.abs(planet[i].z - planet[i + 1].z);
            edgeList.add(new Edge(planet[i].idx, planet[i+1].idx, abs));
        }

        Collections.sort(edgeList, ((o1, o2) -> Integer.compare(o1.weight, o2.weight)));

        int result = 0;
        int count = 0;
        for (Edge edge : edgeList) {
            int start = edge.start;
            int end = edge.end;

            if (find(start) == find(end)) {
                continue;
            }

            union(start, end);
            result += edge.weight;
            count++;
            if (count == n-1) {
                break;
            }
        }

        System.out.println(result);
    }

    private static void union(int start, int end) {
        int first = find(start);
        int second = find(end);

        if (first!=second) {
            if (first > second) {
                arr[first] = second;
            } else {
                arr[second] = first;
            }
        }
    }

    private static int find(int start) {
        if (arr[start] != start) {
            arr[start] = find(arr[start]);
        }

        return arr[start];
    }
}
