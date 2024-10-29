import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 가로 칸 수
        int m = Integer.parseInt(st.nextToken()); // 세로 칸 수
        int[][] visitedArr = new int[n][m]; // 방문 배열

        /**
         * 주어진 미로 표현
         */
        int[][] maze = new int[n][m];
        for (int i = 0; i < n; i++) {
            String givenRow = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = givenRow.charAt(j) - '0';
            }
        }

        int result = bfs(visitedArr, n, m, maze);

        System.out.println(result);
    }

    private static int bfs(int[][] visitedArr, int n, int m, int[][] maze) {
        Queue<int[]> queue = new LinkedList<>();
        visitedArr[0][0] = 1;
        queue.add(new int[]{0, 0, 1});

        int[] directionsRow = {-1, 1, 0, 0};
        int[] directionsCol = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentRow = poll[0]; // 현재 행
            int currentCol = poll[1]; // 현재 열
            int currentDistance = poll[2]; // 최단 경로 길이

            if (currentRow == n - 1 && currentCol == m - 1) {
                return currentDistance;
            }

            for (int k = 0; k < 4; k++) {
                int nextRow = currentRow + directionsRow[k];
                int nextCol = currentCol + directionsCol[k];

                if (nextRow >= 0 && nextRow < n && nextCol >= 0 && nextCol < m && visitedArr[nextRow][nextCol] == 0 && maze[nextRow][nextCol] == 1) {
                    visitedArr[nextRow][nextCol] = 1;
                    queue.add(new int[]{nextRow, nextCol, currentDistance+1});
                }
            }
        }
        return -1; //경로가 없는 경우
    }
}