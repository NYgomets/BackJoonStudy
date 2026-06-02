import java.util.*;

class Solution {
    static int startX;
    static int startY;
    static int endX;
    static int endY;
    static boolean[][] visited;
    static char[][] maze;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public int solution(String[] board) {
        visited = new boolean[board.length][board[0].length()];
        maze = new char[board.length][board[0].length()];
        
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length(); j++) {
                maze[i][j] = board[i].charAt(j);
                if (maze[i][j] == 'R') {
                    startY = i;
                    startX = j;
                } else if (maze[i][j] == 'G') {
                    endY = i;
                    endX = j;
                }
            }
        }
        
        int result = bfs();
        return result;
    }
    
    static public int bfs() {
        int count = -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startY, startX, 0});
        visited[startY][startX] = true;
        
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curY = poll[0];
            int curX = poll[1];
            int curC = poll[2];
            
            if (maze[curY][curX] == 'G') {
                return curC;
            }
            
            for (int i=0; i<4; i++) {
                int nextY = curY;
                int nextX = curX;
                
                while (true) {
                    int tY = nextY + dy[i];
                    int tX = nextX + dx[i];
                    if (tY<0 || tY>=maze.length || tX<0 || tX>=maze[0].length || maze[tY][tX] == 'D') {
                        break;
                    }
                    nextY = tY;
                    nextX = tX;
                }
                
                if (!visited[nextY][nextX]) {
                    visited[nextY][nextX] = true;
                    queue.add(new int[]{nextY, nextX, curC+1});
                }
            }
        }
        
        return count;
    }
}