import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static List<Integer>[] adjList;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1]; // 진입차수 배열
        adjList = new ArrayList[n+1]; // 인접리스트
        for (int i=1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }
        list = new ArrayList<>(); // 위상정렬

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            int prev = Integer.parseInt(st.nextToken());
            for (int j=1; j<k; j++) {
                int current = Integer.parseInt(st.nextToken());
                adjList[prev].add(current);
                arr[current]++;
                prev = current;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            if (arr[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            list.add(poll);

            for (int next : adjList[poll]) {
                arr[next]--;
                if (arr[next] == 0) {
                    queue.add(next);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (list.size() != n) {
            sb.append(0);
        } else {
            for (int i : list) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);
    }
}
