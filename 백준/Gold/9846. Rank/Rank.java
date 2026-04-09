import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static List<Integer>[] adjList;
    static int[] indegree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }
        indegree = new int[n+1];

        for (int i=0; i<m; i++) {
            String s = br.readLine();
            String[] split = s.split(">");
            String[] left = split[0].split(",");
            String[] right = split[1].split(",");

            if (left.length == 1) {
                int first = Integer.parseInt(left[0]);
                int second = Integer.parseInt(right[0]);
                int third = Integer.parseInt(right[1]);
                adjList[first].add(second);
                adjList[first].add(third);
                indegree[second]++;
                indegree[third]++;
            } else {
                int first = Integer.parseInt(left[0]);
                int second = Integer.parseInt(left[1]);
                int third = Integer.parseInt(right[0]);
                adjList[first].add(third);
                adjList[second].add(third);
                indegree[third]++;
                indegree[third]++;
            }
        }

        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            result.add(now);
            for (int i : adjList[now]) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    queue.add(i);
                }
            }
        }

        if (result.size() == n) {
            for (int i : result) {
                System.out.print(i + " ");
            }
        } else {
            System.out.println(0);
        }
    }
}
