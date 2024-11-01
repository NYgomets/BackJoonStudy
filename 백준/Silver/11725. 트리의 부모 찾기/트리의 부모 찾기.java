import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] adjList;
    static boolean[] visitedArr;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 노드 개수
        visitedArr = new boolean[n+1]; // 방문 배열

        /**
         * 인접리스트로 그래프를 표현
         */
        adjList = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i=1; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            adjList[first].add(second);
            adjList[second].add(first);
        }

        result = new int[n+1];
        dfs(1, -1);
        for (int i=2; i<=n; i++) {
            System.out.println(result[i]);
        }
    }

    private static void dfs(int current, int parent) {
        visitedArr[current] = true;

        for (int next : adjList[current]) {
            if (!visitedArr[next]) {
                dfs(next, current);
            } else {
                result[current] = next;
            }
        }
    }
}