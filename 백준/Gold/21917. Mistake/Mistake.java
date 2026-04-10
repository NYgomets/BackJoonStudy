import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static int m;
    static List<Integer>[] adjList;
    static int[] indegree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }
        indegree = new int[n+1];

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            indegree[b]++;
        }

        int[] logs = new int[n*k+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n*k; i++) {
            logs[i] = Integer.parseInt(st.nextToken());
        }

        int[][] indeg = new int[k+1][n+1];
        for (int j=1; j<=k; j++) {
            for (int i=1; i<=n; i++) {
                indeg[j][i] = indegree[i];
            }
        }

        Queue<Integer>[] queue = new Queue[n+1];
        for (int i=1; i<=n; i++) {
            queue[i] = new LinkedList<>();
        }

        for (int j=1; j<=n; j++) {
            if (indegree[j] == 0) {
                for (int i=1; i<=k; i++) {
                    queue[j].add(i);
                }
            }
        }

        int[] result = new int[n*k+1];
        for (int i=1; i<=n*k; i++) {
            int log = logs[i];
            int job = queue[log].poll();
            result[i] = job;

            for (int next : adjList[log]) {
                indeg[job][next]--;
                if (indeg[job][next] == 0) {
                    queue[next].add(job);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=n*k; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }
}
