import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int t;
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
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        for (int i=1; i<=n; i++) {
            arr[i] = i;
        }

        edgeList = new Node[m];
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edgeList[i] = new Node(a, b, c);
        }

        Arrays.sort(edgeList, ((o1, o2) -> o1.getWeight() - o2.getWeight()));

        int result = 0;
        int count = 0;
        for (int i=0; i<m; i++) {
            int start = edgeList[i].getStart();
            int end = edgeList[i].getEnd();

            if (find(start) == find(end)) {
                continue;
            }

            count++;
            result += edgeList[i].getWeight();
            union(start, end);
        }

        for (int i=1; i<count; i++) {
            result += i*t;
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
