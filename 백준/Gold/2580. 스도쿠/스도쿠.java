import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] maze;
    static List<Node> list = new ArrayList<>();
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        maze = new int[9][9];
        StringTokenizer st;
        for (int i=0; i<9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<9; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
                if (maze[i][j] == 0) {
                    list.add(new Node(i, j));
                }
            }
        }

        dfs(0);
    }

    private static void dfs(int count) {
        if (count==list.size()) {
            for (int i=0; i<9; i++) {
                for (int j=0; j<9; j++) {
                    System.out.print(maze[i][j] +" ");
                }
                System.out.println();
            }
            System.exit(0);
        }


        Node node = list.get(count);
        for (int i=1; i<=9; i++) {
            if (safe(node.x, node.y, i)) {
                maze[node.x][node.y] = i;
                dfs(count+1);
                maze[node.x][node.y] = 0;
            }
        }
    }

    private static boolean safe(int x, int y, int num) {
        for (int i=0; i<9; i++) {
            if (maze[x][i]==num) {
                if (i!=y) {
                    return false;
                }
            }
        }

        for (int i=0; i<9; i++) {
            if (maze[i][y]==num) {
                if (i!=x) {
                    return false;
                }
            }
        }

        int startX = (x/3)*3;
        int startY = (y/3)*3;

        for (int i=startX; i<startX+3; i++) {
            for (int j=startY; j<startY+3; j++) {
                if (maze[i][j]==num) {
                    return false;
                }
            }
        }

        return true;
    }
}