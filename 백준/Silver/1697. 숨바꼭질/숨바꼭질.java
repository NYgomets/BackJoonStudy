import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static class Node {
        int distance;
        int time;

        public Node(int distance, int time) {
            this.distance = distance;
            this.time = time;
        }

        public int getDistance() {
            return distance;
        }

        public int getTime() {
            return time;
        }
    }
    static int n;
    static int k;
    static boolean[] visitedArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visitedArr = new boolean[100001];
        bfs(n);

    }

    private static void bfs(int start) {
        Queue<Node> queue = new LinkedList<>();
        visitedArr[start] = true;
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int current = node.distance;

            if (current == k) {
                System.out.println(node.getTime());
                return;
            }

            int[] move = {-1, 1, current};

            for (int i=0; i<3; i++) {
                int next = current + move[i];

                if (next >=0 && next <= 100000 && !visitedArr[next]) {
                    visitedArr[next] = true;
                    queue.add(new Node(next, node.getTime()+1));
                }
            }
        }
    }
}