import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] maze;
    static boolean[][] visitedArr;
    static int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken()); // 가로줄
            int h = Integer.parseInt(st.nextToken()); // 세로줄
            /**
             * 인접행렬로 그래프 표현
             */

            if (h == 0 && w == 0) {
                break;
            }

            visitedArr = new boolean[h][w];
            maze = new int[h][w];
            for (int i=0; i<h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<w; j++) {
                    maze[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i=0; i<h; i++) {
                for (int j=0; j<w; j++) {
                    if (!visitedArr[i][j] && maze[i][j] == 1) {
                        dfs(i, j, h, w);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(int i, int j, int h, int w) {
        visitedArr[i][j] = true;

        for (int k=0; k<8; k++) {
            int nextX = i + dx[k];
            int nextY = j + dy[k];

            if (nextX >=0 && nextX < h && nextY >= 0 && nextY < w && !visitedArr[nextX][nextY] && maze[nextX][nextY] == 1) {
                dfs(nextX, nextY, h, w);
            }
        }
    }
}