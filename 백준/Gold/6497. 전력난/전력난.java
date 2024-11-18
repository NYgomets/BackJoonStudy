import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static Node[] edgeList;
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

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if (n == 0 && m == 0) {
                break;
            }

            arr = new int[n+1];
            for (int i=1; i<=n; i++) {
                arr[i] = i;
            }

            int total = 0;
            edgeList = new Node[m];
            for (int i=0; i<m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                edgeList[i] = new Node(a, b, c);
                total += c;
            }

            Arrays.sort(edgeList, ((o1, o2) -> Integer.compare(o1.getWeight(), o2.getWeight())));

            int result = 0;
            for (int i=0; i<m; i++) {
                int start = edgeList[i].getStart();
                int end = edgeList[i].getEnd();

                if (find(start) == find(end)) {
                    continue;
                }

                union(start, end);
                result += edgeList[i].getWeight();
            }

            System.out.println(total - result);
        }
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
