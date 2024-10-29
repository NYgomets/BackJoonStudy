import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int computer = Integer.parseInt(br.readLine());
        int network = Integer.parseInt(br.readLine());
        boolean[] visitedArr = new boolean[computer+1];

        /**
         * 인접리스트로 그래프를 표현
         */
        List<Integer>[] adjList = new ArrayList[computer+1];
        for (int i=0; i<=computer; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i=0; i<network; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList[u].add(v);
            adjList[v].add(u);
        }

        dfs(1, adjList, visitedArr);

        System.out.println(count);

    }

    private static void dfs(int i, List<Integer>[] adjList, boolean[] visitedArr) {
        visitedArr[i] = true;

        for (int next : adjList[i]) {
            if (!visitedArr[next]) {
                dfs(next, adjList, visitedArr);
                count++;
            }
        }
    }
}