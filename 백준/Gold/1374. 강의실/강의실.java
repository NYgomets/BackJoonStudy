import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Node[] nodes;
    static class Node {
        int idx;
        long start;
        long end;

        public Node(int idx, long start, long end) {
            this.idx = idx;
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nodes = new Node[n];
        StringTokenizer st;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            nodes[i] = new Node(a, b, c);
        }

        Arrays.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Long.compare(o1.start, o2.start);
            }
        });

        Queue<Long> queue = new PriorityQueue<>();
        queue.add(nodes[0].end);
        for (int i=1; i<n; i++) {
            if (nodes[i].start >= queue.peek()) {
                queue.poll();
                queue.add(nodes[i].end);
            } else {
                queue.add(nodes[i].end);
            }
        }

        System.out.println(queue.size());
    }
}
