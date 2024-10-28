import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점의 개수
        int M = Integer.parseInt(st.nextToken()); // 간선의 개수
        boolean[] visitedArr = new boolean[N+1]; // 방문 여부 검사

        /**
            인접리스트로 그래프를 표현
         */
        List<Integer>[] adjList = new LinkedList[N+1];
        for (int i=0; i<=N; i++) {
            adjList[i] = new LinkedList<>();
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList[u].add(v);
            adjList[v].add(u);
        }

        for (int i=1; i<=N; i++) {
            if (!visitedArr[i]) {
                dfs(i, adjList, visitedArr);
                count++;
            }
        }

        System.out.println(count);
    }

    private static void dfs(int i, List<Integer>[] adjList, boolean[] visitedArr) {
        visitedArr[i] = true;

        Iterator<Integer> iter = adjList[i].listIterator();
        while (iter.hasNext()) {
            int next = iter.next();
            if (!visitedArr[next]) {
                dfs(next, adjList, visitedArr);
            }
        }
    }
}