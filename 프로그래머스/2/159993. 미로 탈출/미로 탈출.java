import java.util.*;

class Solution {
    static boolean[][] visited;
    static String[][] maze;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public int solution(String[] maps) {
        int answer = 0;
        
        maze = new String[maps.length][maps[0].length()];
        
        int startY = 0;
        int startX = 0;
        int leverY = 0;
        int leverX = 0;
        int endY = 0;
        int endX = 0;
        for (int i=0; i<maps.length; i++) {
            String[] s = maps[i].split("");
            for (int j=0; j<s.length; j++) {
                maze[i][j] = s[j];
                if (maze[i][j].equals("S")) {
                    startY = i;
                    startX = j;
                } else if (maze[i][j].equals("L")) {
                    leverY = i;
                    leverX = j;
                } else if (maze[i][j].equals("E")) {
                    endY = i;
                    endX = j;
                }
            }
        }
        visited = new boolean[maps.length][maps[0].length()];
        int num1 = bfs(startY, startX, "L");
        if (num1 == -1) {
            return -1;
        }
        answer += num1;
        visited = new boolean[maps.length][maps[0].length()];
        int num2 = bfs(leverY, leverX, "E");
        if (num2 == -1) {
            return -1;
        }
        answer += num2;
        return answer;
    }
    
    static public int bfs(int startY, int startX, String end) {
        int result = -1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startY, startX, 0});
        visited[startY][startX] = true;
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curY = poll[0];
            int curX = poll[1];
            int cost = poll[2];
        
            if (maze[curY][curX].equals(end)) {
                return cost;
            }
            
            for (int i=0; i<4; i++) {
                int nY = curY + dy[i];
                int nX = curX + dx[i];
                
                if (nY<0 || nY>=maze.length || nX<0 || nX>=maze[0].length) {
                    continue;
                }
                if (visited[nY][nX]) {
                    continue;
                }
                
                if (maze[nY][nX].equals("X")) {
                    continue;
                }
                
                visited[nY][nX] = true;
                queue.add(new int[]{nY, nX, cost+1});
            }
        }
        
        return result;
    }
}