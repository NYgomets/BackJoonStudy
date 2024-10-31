import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[] result = new int[t];

        for (int l=0; l<t; l++) {
            String[] split = br.readLine().split(" ");
            int n = Integer.parseInt(split[0]); // 가로 길이
            int m = Integer.parseInt(split[1]); // 세로 길이
            int k = Integer.parseInt(split[2]); // 배추 개수
            int[][] visitedArr = new int[n+1][m+1]; // 방문 배열

            /**
             * 인접리스트로 그래프를 표현
             */
            int[][] maze = new int[n][m];

            for (int j=0; j<k; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                maze[x][y] = 1;
            }

            for (int r=0; r<n; r++) {
                for (int p=0; p<m; p++) {
                    if (visitedArr[r][p] == 0 && maze[r][p] == 1) {
                        bfs(r, p, visitedArr, maze, n, m);
                        result[l]++;
                    }
                }
            }

            System.out.println(result[l]);
        }
    }

    private static void bfs(int r, int p, int[][] visitedArr, int[][] maze, int n, int m) {
        visitedArr[r][p] = 1;

        int[] directionX = {-1, 1, 0, 0};
        int[] directionY = {0, 0, -1, 1};

        for (int k=0; k<4; k++) {
            int nextX = r + directionX[k];
            int nextY = p + directionY[k];

            if (nextX >=0 && nextX < n && nextY >= 0 && nextY < m && visitedArr[nextX][nextY] == 0 && maze[nextX][nextY] == 1) {
                bfs(nextX, nextY, visitedArr, maze, n, m);
            }
        }
    }
}