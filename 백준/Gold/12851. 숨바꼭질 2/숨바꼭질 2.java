import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int n;
    static int k;
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
    static boolean[] visitedArr;
    static int shortestTime = Integer.MAX_VALUE;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visitedArr = new boolean[100001];
        bfs(n);
        System.out.println(shortestTime);
        System.out.println(count);
    }

    private static void bfs(int start) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int current = poll.getN();
            int currentTime = poll.getW();

            visitedArr[current] = true;

            if (current == k) {
                if (shortestTime > currentTime) {
                    shortestTime = currentTime;
                    count = 1;
                } else if (currentTime == shortestTime){
                    count++;
                }
            }

            int[] move = {-1, 1, current};
            for (int i=0; i<3; i++) {
                int next = current + move[i];

                if (next >= 0 && next <= 100000 && !visitedArr[next]) {
                    queue.offer(new Node(next, currentTime+1));
                }
            }
        }
    }
}