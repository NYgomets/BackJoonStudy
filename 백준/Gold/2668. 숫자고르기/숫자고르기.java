import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static List<Integer>[] list;
    static boolean[] visited;
    static boolean[] checked;
    static List<Integer> sorted;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i=1; i<=n; i++) {
            int a = Integer.parseInt(br.readLine());
            list[i].add(a);
        }

        sorted = new ArrayList<>();
        visited = new boolean[n+1];
        checked = new boolean[n+1];

        for (int i=1; i<=n; i++) {
            dfs(i);
        }

        Collections.sort(sorted);
        sb.append(result).append("\n");
        for (int c : sorted) {
            sb.append(c).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int start) {
        visited[start] = true;

        for (int next : list[start]) {
            if (!visited[next]) {
                dfs(next);
            } else if (!checked[next]) {
                int temp = next;
                do {
                    result++;
                    temp = list[temp].get(0);
                    sorted.add(temp);
                } while (temp != next);
            }
        }

        checked[start] = true;
    }
}