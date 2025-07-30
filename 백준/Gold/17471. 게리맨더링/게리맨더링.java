import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] person;
    static List<Integer>[] adjList;
    static int MID = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        person = new int[n+1];
        adjList = new ArrayList[n+1];
        for (int i=1; i<=n; i++) {
            adjList[i] = new ArrayList<>();
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
            person[i] = Integer.parseInt(st.nextToken());
        }
        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for (int j=0; j<a; j++) {
                int b = Integer.parseInt(st.nextToken());
                adjList[i].add(b);
            }
        }

        List<Integer> redList = new ArrayList<>();
        subset(1, redList);
        if (MID == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(MID);
        }
    }

    private static void subset(int current, List<Integer> redList) {
        if (current>n) {
            return;
        }

        redList.add(current);
        List<Integer> blueList = blueList(redList);
        if (isConnect(redList) && isConnect(blueList)) {
            int red = 0;
            for (int i : redList) {
                red += person[i];
            }

            int blue = 0;
            for (int i : blueList) {
                blue += person[i];
            }

            MID = Math.min(MID, Math.abs(red-blue));
        }
        subset(current+1, redList);

        redList.remove((Integer) current);
        blueList = blueList(redList);
        if (isConnect(redList) && isConnect(blueList)) {
            int red = 0;
            for (int i : redList) {
                red += person[i];
            }

            int blue = 0;
            for (int i : blueList) {
                blue += person[i];
            }

            MID = Math.min(MID, Math.abs(red-blue));
        }
        subset(current+1, redList);
    }

    private static List<Integer> blueList(List<Integer> redList) {
        List<Integer> blueList = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>(redList);
        for (int i=1; i<=n; i++) {
            if (!set.contains(i)) {
                blueList.add(i);
            }
        }
        return blueList;
    }

    private static boolean isConnect(List<Integer> list) {
        if (list.isEmpty()) {
            return false;
        }

        Set<Integer> set = new HashSet<>(list);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        int count = 1;
        int num = list.get(0);
        queue.add(num);
        visited[num] = true;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            for (int i : adjList[current]) {
                if (set.contains(i) && !visited[i]) {
                    count++;
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

        if (count==list.size()) {
            return true;
        } else {
            return false;
        }
    }
}