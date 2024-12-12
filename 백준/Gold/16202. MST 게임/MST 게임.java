import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int k;
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
        k = Integer.parseInt(st.nextToken());
        arr = new int[n+1];

        edgeList = new ArrayList<>();
        for (int i=1; i<=m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edgeList.add(new Node(a, b, i));
        }

        Collections.sort(edgeList, ((o1, o2) -> o1.weight-o2.weight));

        for (int l=0; l<k; l++) {
            if (edgeList.size() < n-1) {
                System.out.print(0 + " ");
                continue;
            }

            for (int i=1; i<=n; i++) {
                arr[i] = i;
            }

            int result = 0;
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
                if (count == n-1) {
                    break;
                }
            }

            if (count != n-1) {
                System.out.print(0 + " ");
            } else {
                System.out.print(result + " ");
            }

            edgeList.remove(0);
        }
    }

    public static void union(int a, int b) {
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
