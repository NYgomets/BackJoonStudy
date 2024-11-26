import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static List<Integer>[] list;
    static List<Integer> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        list = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            arr[b]++;
        }

        Queue<Integer> queue = new PriorityQueue<>();
        for (int i=1; i<=n; i++) {
            if (arr[i] == 0) {
                queue.add(i);
            }
        }

        result = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            result.add(poll);

            for (int next : list[poll]) {
                arr[next]--;
                if (arr[next] == 0) {
                    queue.add(next);
                }
            }
        }

        for (int a : result) {
            System.out.print(a + " ");
        }
    }
}
