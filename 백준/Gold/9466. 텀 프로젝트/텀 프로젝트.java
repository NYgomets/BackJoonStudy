import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static List<Integer>[] adjList;
    static boolean[] visited;
    static boolean[] cycle;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int l = 0; l < t; l++) {
            n = Integer.parseInt(br.readLine());
            adjList = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                adjList[i] = new ArrayList<>();
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                adjList[i].add(Integer.parseInt(st.nextToken()));
            }

            visited = new boolean[n + 1];
            cycle = new boolean[n + 1];
            result = 0;

            for (int i = 1; i <= n; i++) {
                roop(i);
            }
            sb.append(n - result).append("\n");
        }
        System.out.println(sb);
    }

    private static void roop(int start) {
        visited[start] = true;

        for (int next : adjList[start]) {
            if (!visited[next]) {
                roop(next);
            } else if (!cycle[next]) {
                int temp = next;
                do {
                    result++;
                    temp = adjList[temp].get(0);
                } while (temp!=next);
            }
        }

        cycle[start] = true;
    }
}
