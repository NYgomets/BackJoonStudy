import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int sX1;
    static int sY1;
    static int sX2;
    static int sY2;
    static char[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        boolean check = false;
        board = new char[n][m];
        for (int i=0; i<n; i++) {
            String s = br.readLine();
            for (int j=0; j<m; j++) {
                board[i][j] = s.charAt(j);
                if (board[i][j] == 'o' && !check) {
                    sY1 = i;
                    sX1 = j;
                    check = true;
                } else if (board[i][j] == 'o' && check){
                    sY2 = i;
                    sX2 = j;
                }
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sY1, sX1, sY2, sX2, 0});
        int result = -1;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curY1 = poll[0];
            int curX1 = poll[1];
            int curY2 = poll[2];
            int curX2 = poll[3];
            int curTime = poll[4];

            if (curTime >= 10) {
                return result;
            }

            for (int i=0; i<4; i++) {
                int nY1 = curY1 + dy[i];
                int nX1 = curX1 + dx[i];
                int nY2 = curY2 + dy[i];
                int nX2 = curX2 + dx[i];

                boolean o1 = nY1<0 || nY1>=n || nX1<0 || nX1>=m;
                boolean o2 = nY2<0 || nY2>=n || nX2<0 || nX2>=m;

                if (o1 && o2) {
                    continue;
                }
                if (o1 || o2) {
                    return curTime+1;
                }

                if (board[nY1][nX1] == '#') {
                    nY1 = curY1;
                    nX1 = curX1;
                }
                if (board[nY2][nX2] == '#') {
                    nY2 = curY2;
                    nX2 = curX2;
                }

                queue.add(new int[]{nY1, nX1, nY2, nX2, curTime+1});
            }
        }

        return result;
    }
}