import java.io.*;
import java.util.*;

public class Main {
    static int n = 8500;
    static boolean[] isPrime;
    static int startX;
    static int startY;
    static int endX;
    static int endY;
    static List<Node> list;
    static class Node {
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
    static boolean[] visited;
    static int[] shortest;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        erasto();
        StringTokenizer st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken());
        startY = Integer.parseInt(st.nextToken());
        endX = Integer.parseInt(st.nextToken());
        endY = Integer.parseInt(st.nextToken());
        int village = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        list.add(new Node(startX, startY, 0));
        for (int i=0; i<village; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Node(x, y, i+1));
        }
        list.add(new Node(endX, endY, village+1));

        int distance = distance(startX, startY, endX, endY);

        visited = new boolean[village+2];
        shortest = new int[village+2];
        Arrays.fill(shortest, Integer.MAX_VALUE);
        shortest[0] = 0;

        dikstra();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        if (shortest[village+1] == Integer.MAX_VALUE) {
            bw.write("-1");
        } else {
            bw.write(String.valueOf(shortest[village+1]));
        }

        bw.flush();
        bw.close();
    }

    private static int distance(int sX, int sY, int eX, int eY) {
        int dx = eX - sX;
        int dy = eY - sY;
        return (int)Math.sqrt(dx * dx + dy * dy);
    }

    private static void dikstra() {
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        queue.add(new int[]{startX, startY, 0, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curX = poll[0];
            int curY = poll[1];
            int check = poll[3];

            if (visited[check]) {
                continue;
            }
            visited[check] = true;

            for (int i=0; i<list.size(); i++) {
                Node node = list.get(i);
                int nextX = node.x;
                int nextY = node.y;
                int nextCount = node.count;

                int distance = distance(curX, curY, nextX, nextY);
                if (!isPrime[distance]) {
                    continue;
                }

                if (shortest[nextCount] > shortest[check] + distance) {
                    shortest[nextCount] = shortest[check] + distance;
                    queue.add(new int[]{nextX, nextY, shortest[nextCount], nextCount});
                }
            }
        }
    }

    private static void erasto() {
        for (int i=2; i<=Math.sqrt(n); i++) {
            if (!isPrime[i]) {
                continue;
            }
            for (int j=i*i; j<=n; j+=i) {
                isPrime[j] = false;
            }
        }
    }
}