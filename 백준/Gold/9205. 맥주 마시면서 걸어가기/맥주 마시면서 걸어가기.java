import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int rockX;
    static int rockY;
    static List<Node> position;
    static boolean[] visited;
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int l=0; l<t; l++) {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            position = new ArrayList<>();
            int houseX = Integer.parseInt(st.nextToken());
            int houseY = Integer.parseInt(st.nextToken());

            for (int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                position.add(new Node(a, b));
            }
            st = new StringTokenizer(br.readLine());
            rockX = Integer.parseInt(st.nextToken());
            rockY = Integer.parseInt(st.nextToken());
            position.add(new Node(rockX, rockY));
            visited = new boolean[n+2];

            if (bfs(houseX, houseY)) {
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }
        }
    }

    private static boolean bfs(int houseX, int houseY) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(houseX, houseY));
        visited[0] = true;

        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int currentX = poll.x;
            int currentY = poll.y;

            if (visited[n+1]) {
                return true;
            }

            for (int i=0; i<position.size(); i++) {
                int nextX = position.get(i).x;
                int nextY = position.get(i).y;

                if (!visited[i+1] && Math.abs(nextX-currentX) + Math.abs(nextY-currentY) <= 1000) {
                    visited[i+1] = true;
                    queue.add(new Node(nextX, nextY));
                }
            }
        }

        return false;
    }
}
