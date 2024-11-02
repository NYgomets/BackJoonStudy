import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<Integer>[] adjList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arrFirst = new int[n+1]; // 진입차수 배열
        List<Integer> listSecond = new ArrayList<>(); //위상 정렬

        /**
         * 인접리스트로 방향 그래프를 표현
         */
        adjList = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            arrFirst[b]++;
        }

        while (listSecond.size()<n) {
            for (int i=1; i<=n; i++) {
                if (arrFirst[i] == 0) {
                    listSecond.add(i);
                    for (int j : adjList[i]) {
                        arrFirst[j]--;
                    }
                    arrFirst[i]--;
                    break;
                }
            }
        }

        for (int k : listSecond) {
            System.out.print(k + " ");
        }
    }
}