import java.io.*;
import java.util.*;

public class Main {
    static int line;
    static int[][] map;
    static boolean[][] visit;
    static int count;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static List<Integer> num;

    static void dfs(int x, int y) {
        visit[x][y] = true;
        count++;

        // map[x][y] 좌표의 상하좌우 move
        for (int i=0; i<4; i++) {
            int x1 = x + dx[i];
            int y1 = y + dy[i];

            if (x1<0 || x1>=line || y1<0 || y1>=line) {
                continue;
            } else if (map[x1][y1] == 1 && !visit[x1][y1]) {
                dfs(x1, y1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        line = Integer.parseInt(br.readLine());
        map = new int[line][line];
        visit = new boolean[line][line];
        num = new ArrayList<Integer>();

        for (int i=0; i<line; i++) {
            String s = br.readLine();
            for (int j=0; j<line; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i=0; i<line; i++) {
            for (int j=0; j<line; j++) {
                if (map[i][j] == 1 && !visit[i][j]) {
                    count = 0;
                    dfs(i, j);
                    num.add(count);
                }
            }
        }

        Collections.sort(num);

        System.out.println(num.size());
        for (Integer integer : num) {
            System.out.println(integer);
        }

        br.close();
    }
}