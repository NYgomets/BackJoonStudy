import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static List<Integer>[] adjList;
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
        List<Integer> list = new ArrayList<>(); // 위상정렬
        int[] semester = new int[n+1];
        Arrays.fill(semester, 1);

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            arr[b]++;
        }

        while (list.size() < n) {
            for (int i=1; i<=n; i++) {
                if (arr[i] == 0) {
                    list.add(i);
                    for (int next : adjList[i]) {
                        arr[next]--;
                        if (semester[next] < semester[i] + 1) {
                            semester[next] = semester[i] + 1;
                        }
                    }
                    arr[i]--;
                    break;
                }
            }
        }

        for (int i=1; i<=n; i++) {
            System.out.print(semester[i] + " ");
        }
    }
}
