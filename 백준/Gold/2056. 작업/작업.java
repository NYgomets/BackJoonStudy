import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static List<Integer>[] adjList;
    static List<Integer> list;
    static int[] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        time = new int[n+1];
        arr = new int[n+1];
        adjList = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }
        list = new ArrayList<>();

        for (int i=1; i<=n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            time[i] = t;

            int no = Integer.parseInt(st.nextToken());
            for (int j=0; j<no; j++) {
                int prev = Integer.parseInt(st.nextToken());
                adjList[prev].add(i);
                arr[i]++;
            }
        }

        int[] resultTime = new int[n+1];
        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            if (arr[i] == 0) {
                resultTime[i] = time[i];
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            list.add(poll);

            for (int next : adjList[poll]) {
                arr[next]--;
                resultTime[next] = Math.max(resultTime[next], resultTime[poll] + time[next]);
                if (arr[next] == 0) {
                    queue.add(next);
                }
            }
        }

        int result = 0;
        for (int i=1; i<=n; i++) {
            if (result < resultTime[i]) {
                result = resultTime[i];
            }
        }
        System.out.println(result);
    }
}
