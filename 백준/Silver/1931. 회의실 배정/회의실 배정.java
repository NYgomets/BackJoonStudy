import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static Node[] nodes;
    static class Node {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        nodes = new Node[n];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(a, b);
        }

        Arrays.sort(nodes, ((o1, o2) ->
        {
            if (o1.getEnd() == o2.getEnd()) {
                return o1.getStart() - o2.getStart();
            } else {
                return o1.getEnd() - o2.getEnd();
            }
        }
        ));

        int result = 0;
        int lastTime = -1;
        for (int i=0; i<n; i++) {
            if (nodes[i].getStart() >= lastTime) {
                result++;
                lastTime = nodes[i].getEnd();
            }
        }
        System.out.println(result);

    }
}
