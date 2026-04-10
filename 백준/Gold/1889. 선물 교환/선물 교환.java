import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static List<Integer>[] adjList;
    static int[] indegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        indegree = new int[n+1];
        adjList = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        // 입력 처리
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[i].add(a);
            adjList[i].add(b);
            indegree[a]++;
            indegree[b]++;
        }

        boolean[] alive = new boolean[n+1];
        Arrays.fill(alive, true);
        boolean[] inQueue = new boolean[n+1];

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] < 2) {
                queue.add(i);
                inQueue[i] = true;
            }
        }
        
        while (!queue.isEmpty()) {
            int now = queue.poll();
            alive[now] = false;

            for (int next : adjList[now]) {
                indegree[next]--;
                if (alive[next] && !inQueue[next] && indegree[next] < 2) {
                    queue.add(next);
                    inQueue[next] = true;
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (alive[i]) {
                result.add(i);
            }
        }

        if (result.isEmpty()) {
            System.out.println(0);
            return;
        }

        Collections.sort(result);
        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(" ");
        }

        System.out.println(result.size());
        System.out.println(sb);
    }
}