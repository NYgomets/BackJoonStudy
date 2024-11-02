import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] adjList;
    static int[] time;
    static int[] buildingTime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스
        for (int l=0; l<t; l++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            /**
             * 건물 당 걸리는 시간
             */
            time = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for (int i=1; i<=n; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }

            /**
             * 인접리스트로 그래프를 표현
             */
            int[] arr = new int[n+1]; // 진입차수 배열
            adjList = new ArrayList[n+1];
            for (int i=1; i<=n; i++) {
                adjList[i] = new ArrayList<>();
            }
            for (int i=0; i<k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                adjList[x].add(y);
                arr[y]++;
            }

            buildingTime = new int[n+1];
            /**
             * 위상정렬 배열
             */
            Queue<Integer> queue = new LinkedList<>();
            for (int i=1; i<=n; i++) {
                if (arr[i] == 0) {
                    buildingTime[i] = time[i];
                    queue.offer(i);
                }
            }

            while (!queue.isEmpty()) {
                int poll = queue.poll();
                for (int next : adjList[poll]) {
                    arr[next]--;
                    buildingTime[next] = Math.max(buildingTime[next], buildingTime[poll]+time[next]);
                    if (arr[next] == 0) {
                        queue.offer(next);
                    }
                }
            }

            int givenNum = Integer.parseInt(br.readLine());

            System.out.println(buildingTime[givenNum]);
        }
    }
}