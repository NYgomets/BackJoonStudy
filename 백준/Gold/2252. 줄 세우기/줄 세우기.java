import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static List<Integer>[] adjList;
    static int[] digist;
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        adjList = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }
        digist = new int[n+1];

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            digist[b]++;
        }

        while (result.size() < n) {
            for (int i=1; i<=n; i++) {
                if (digist[i] == 0) {
                    result.add(i);
                    for (int num : adjList[i]) {
                        digist[num]--;
                    }
                    digist[i]--;
                    break;
                }
            }
        }

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
