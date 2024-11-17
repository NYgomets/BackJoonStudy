import java.io.*;
import java.util.*;

public class Main {
    static int v;
    static int e;
    static Node[] edgeList;
    static int[] arr;
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
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        arr = new int[v+1];
        for (int i=1; i<=v; i++) {
            arr[i] = i;
        }
        edgeList = new Node[e];

        for (int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edgeList[i] = new Node(a, b, c);
        }

        Arrays.sort(edgeList, (o1, o2) -> o1.getWeight() - o2.getWeight());

        int result = 0;
        for (int i=0; i<e; i++) {
            int checkA = edgeList[i].getStart();
            int checkB = edgeList[i].getEnd();

            if (find(checkA) == find(checkB)) {
                continue;
            }
            union(checkA, checkB);
            result += edgeList[i].getWeight();
        }

        System.out.println(result);
    }

    public static void union(int a, int b) {
        int first = find(a);
        int second = find(b);

        if (first!=second) {
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
