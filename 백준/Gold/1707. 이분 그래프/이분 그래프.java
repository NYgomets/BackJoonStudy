import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 수

        for (int l=0; l<t; l++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken()); // 노드의 수
            int e = Integer.parseInt(st.nextToken()); // 간선의 수
            int[] visitedArr = new int[v+1]; // 방문 : 0, red : 1, blue : 2
            boolean result = true;

            /**
             * 인접리스트로 그래프 표현
             */
            List<Integer>[] adjList = new ArrayList[v+1];
            for (int j=1; j<=v; j++) {
                adjList[j] = new ArrayList<>();
            }
            for (int i=0; i<e; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adjList[a].add(b);
                adjList[b].add(a);
            }

            for (int k=1; k<=v; k++) {
                if (visitedArr[k] == 0) {
                    result = dfs(k,1, adjList, visitedArr);
                    if (!result) {
                        break;
                    }
                }
            }

            if (result) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean dfs(int current, int color, List<Integer>[] adjList, int[] visitedArr) {
        visitedArr[current] = color;

        for (int next : adjList[current]) {
            if (visitedArr[next] == 0) {
                if (!dfs(next, 3-color, adjList, visitedArr)) {
                    return false;
                }
            } else if (visitedArr[next] == color) {
                return false;
            }
        }
        return true;
    }
}