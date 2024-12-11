import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static long k;
    static int[] stone;
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
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Long.parseLong(st.nextToken());
        arr = new int[n+1];
        for (int i=1; i<=n; i++) {
            arr[i] = i;
        }
        stone = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
            stone[i] = Integer.parseInt(st.nextToken());
        }

        edgeList = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            edgeList.add(new Node(0, i, stone[i]));
        }

        Set<String> set = new HashSet<>();
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            set.add(a + "," + b);
        }

        for (int i=1; i<=n; i++) {
           int next = (i%n)+1;
           if (!set.contains(i + "," + next)) {
               edgeList.add(new Node(i, next, 0));
           }
        }


        if (m <=1) {
            System.out.println("YES");
            return;
        }
        Collections.sort(edgeList, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.weight-o2.weight;
            }
        });

        long result = 0;
        int count = 0;
        for (Node node : edgeList) {
            int start = node.start;
            int end = node.end;

            if (find(start) == find(end)) {
                continue;
            }

            union(start, end);
            count++;
            result += node.weight;
            if (count == n) {
                break;
            }
        }

        if (result <= k) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static void union(int a, int b) {
        int first = find(a);
        int second = find(b);

        if (first!=second) {
            if (first>second) {
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
