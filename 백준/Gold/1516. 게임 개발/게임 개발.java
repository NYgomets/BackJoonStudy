import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static int[] time; // 건물당 걸리는 시간
    static int[] buildingTime;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        time = new int[n+1];
        buildingTime = new int[n+1];

        list = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            time[i] = t;

            while (st.hasMoreTokens()) {
                int prev = Integer.parseInt(st.nextToken());
                if (prev != -1) {
                    list[prev].add(i);
                    arr[i]++;
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            if (arr[i] == 0) {
                buildingTime[i] = time[i];
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (int next : list[poll]) {
                arr[next]--;
                buildingTime[next] = Math.max(buildingTime[next], buildingTime[poll]+time[next]);
                if (arr[next] == 0) {
                    queue.add(next);
                }
            }
        }

        for (int i=1; i<=n; i++) {
            System.out.println(buildingTime[i]);
        }
    }
}
