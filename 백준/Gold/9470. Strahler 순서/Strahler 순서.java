import java.io.*;
import java.util.*;

public class Main {
    static int t;
    static int[] arr;
    static List<Integer>[] adjList;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for (int l=0; l<t; l++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            arr = new int[m+1];
            adjList = new ArrayList[m+1];
            for (int i=1; i<=m; i++) {
                adjList[i] = new ArrayList<>();
            }

            for (int i=0; i<p; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adjList[a].add(b);
                arr[b]++;
            }

            int[] time = new int[m+1];
            boolean[][] state = new boolean[m+1][m+1];
            Queue<Integer> queue = new LinkedList<>();
            for (int i=1; i<=m; i++) {
                if (arr[i] == 0) {
                    queue.add(i);
                    time[i] = 1;
                }
            }

            while (!queue.isEmpty()) {
                Integer poll = queue.poll();
                list.add(poll);

                for (int next : adjList[poll]) {
                    if (state[time[poll]][next]) {
                        time[next] = Math.max(time[next], time[poll]+1);
                    } else {
                        state[time[poll]][next] = true;
                        time[next] = Math.max(time[next], time[poll]);
                    }
                    arr[next]--;
                    if (arr[next] == 0) {
                        queue.add(next);
                    }
                }
            }

            System.out.println(k + " "+ time[m]);
        }
    }
}
