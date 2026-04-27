import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static int[] left;
    static int[] right;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        left = new int[n+1];
        right = new int[n+1];
        String l = br.readLine();
        String r = br.readLine();
        for (int i=1; i<=n; i++) {
            left[i] = l.charAt(i-1) - '0';
        }
        for (int i=1; i<=n; i++) {
            right[i] = r.charAt(i-1) - '0';
        }

        boolean result = bfs();
        if (result) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static boolean bfs() {
        boolean[][] visited = new boolean[2][n+1];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 1, 0});
        boolean result = false;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int direction = poll[0];
            int index = poll[1];
            int time = poll[2];

            if (index >= n) {
                return true;
            }

            if (direction == 0) {
                if (index+1 > n) {
                    return true;
                } else if (left[index+1] == 1 && !visited[direction][index+1]) {
                    visited[direction][index+1] = true;
                    queue.add(new int[]{direction, index+1, time+1});
                }
                if (left[index-1] == 1 && index-1 > time+1 && index-1 >=1 && !visited[direction][index-1]) {
                    visited[direction][index-1] = true;
                    queue.add(new int[]{direction, index-1, time+1});
                }
                if (index+k > n) {
                    return true;
                } else if (right[index+k] == 1 && !visited[1][index+k]) {
                    visited[1][index+k] = true;
                    queue.add(new int[]{1, index+k, time+1});
                }
            }
            if (direction == 1) {
                if (index+1 > n) {
                    return true;
                } else if (right[index+1] == 1 && !visited[direction][index+1]) {
                    visited[direction][index+1] = true;
                    queue.add(new int[]{direction, index+1, time+1});
                }
                if (right[index-1] == 1 && index-1 > time+1 && index-1 >=1 && !visited[direction][index-1]) {
                    visited[direction][index-1] = true;
                    queue.add(new int[]{direction, index-1, time+1});
                }
                if (index+k > n) {
                    return true;
                } else if (left[index+k] == 1 && !visited[0][index+k]) {
                    visited[0][index+k] = true;
                    queue.add(new int[]{0, index+k, time+1});
                }
            }
        }

        return result;
    }
}