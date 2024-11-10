import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int n; //도시의 개수
    static int m; //도로의 개수
    static int k; //거리 정보
    static int x; //출발 도시
    static boolean[] visitedArr;
    static int[] shortestArr;
    static List<Integer>[] adjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        shortestArr = new int[n+1];
        for (int i=1; i<=n; i++) {
            if (i==x) {
                shortestArr[i] = 0;
            } else {
                shortestArr[i] = Integer.MAX_VALUE;
            }
        }
        visitedArr = new boolean[n+1];
        adjList = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
        }

        dikstra(x);

        boolean check = false;
        for (int i=1; i<=n; i++) {
            if (shortestArr[i] == k) {
                System.out.println(i);
                check = true;
            }
        }

        if (!check) {
            System.out.println(-1);
        }
    }

    private static void dikstra(int start) {
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        queue.add(new int[]{start, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int current = poll[0];
            int currentDis = 1;

            if (visitedArr[current]) {
                continue;
            }
            visitedArr[current] = true;

            for (int next : adjList[current]) {
                if (shortestArr[next] > shortestArr[current] + currentDis) {
                    shortestArr[next] = shortestArr[current] + currentDis;
                    queue.offer(new int[]{next, shortestArr[next]});
                }
            }
        }
    }
}