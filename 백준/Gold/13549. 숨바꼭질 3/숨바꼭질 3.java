import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static boolean[] visitedArr;
    static class Node {
        int n;
        int w;

        public Node(int n, int w) {
            this.n = n;
            this.w = w;
        }

        public int getN() {
            return n;
        }

        public int getW() {
            return w;
        }
    }
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
            Node poll = queue.poll();
            int current = poll.getN();
            int currentTime = poll.getW();

            if (current == k) {
                System.out.println(poll.getW());
                return;
            }

            int[] move = {current, -1, 1};
            for (int i=0; i<3; i++) {
                int next = current + move[i];

                if (next >= 0 && next <= 100000 && !visitedArr[next]) {
                    visitedArr[next] = true;
                    if (move[i] == current) {
                        queue.offer(new Node(next, currentTime));
                    } else {
                        queue.offer(new Node(next, currentTime+1));
                    }
                }
            }
        }
    }
}