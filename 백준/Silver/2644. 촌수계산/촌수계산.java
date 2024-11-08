import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int first;
    static int second;
    static int m;
    static boolean[] visitedArr;
    static List<Integer>[] adjList;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        first = Integer.parseInt(st.nextToken());
        second = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        visitedArr = new boolean[n+1];
        adjList = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adjList[x].add(y);
            adjList[y].add(x);
        }

        dfs(first, 0);

        if (!visitedArr[second]) {
            System.out.println(-1);
        } else {
            System.out.println(count);
        }
    }

    private static void dfs(int start, int depth) {
        visitedArr[start] = true;

        if (start == second) {
            count = depth;
            return;
        }

        for (int next : adjList[start]) {
            if (!visitedArr[next]) {
                dfs(next, depth+1);
            }
        }
    }
}