import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int n;
    static int m;
    static boolean[][] visited;
    static int[][] maze;
    static List<Node> house;
    static List<Node> chicken;
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] directionX = {-1, 1, 0, 0};
    static int[] directionY = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        house = new ArrayList<>();
        chicken = new ArrayList<>();
        maze = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=n; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
                if (maze[i][j] == 1) {
                    house.add(new Node(i, j));
                } else if (maze[i][j] == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }

        visited = new boolean[n+1][n+1];
        dfs(0, 0);

        System.out.println(min);
    }

    private static void dfs(int start, int count) {
        if (count == m) {
            int result = calculating();
            min = Math.min(min, result);
            return;
        }

        for (int i=start; i<chicken.size(); i++) {
            if (!visited[chicken.get(i).x][chicken.get(i).y]) {
                visited[chicken.get(i).x][chicken.get(i).y] = true;
                dfs(i+1, count+1);
                visited[chicken.get(i).x][chicken.get(i).y] = false;
            }
        }
    }

    private static int calculating() {
        int total = 0;
        for (Node node : house) {
            total += bfs(node);
        }

        return total;
    }

    private static int bfs(Node node) {
        int mini = Integer.MAX_VALUE;
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                if (visited[i][j]) {
                    mini = Math.min(mini, Math.abs(i- node.x)+Math.abs(j- node.y));
                }
            }
        }

        return mini;
    }
}
