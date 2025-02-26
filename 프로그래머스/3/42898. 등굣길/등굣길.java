import java.util.*;

class Solution {
    static Integer[][] dp;
    static int[][] maze;
    static int[] directionX = {1, 0};
    static int[] directionY = {0, 1};
    public int solution(int m, int n, int[][] puddles) {
        maze = new int[n][m];
        dp = new Integer[n][m];
        
        for (int[] puddle : puddles) {
            int x = puddle[1]-1;
            int y = puddle[0]-1;
            maze[x][y] = -1;
        }
        
        int answer = dfs(m, n, 0, 0);
        return answer;
    }
    
    public int dfs(int m, int n, int x, int y) {
        if (x == n-1 && y == m-1) {
            return 1;
        }
        
        if (dp[x][y] != null) {
            return dp[x][y];
        }
        
        int count = 0;
        for (int i=0; i<2; i++) {
            int nextX = x+directionX[i];
            int nextY = y+directionY[i];
            
            if (nextX<0 || nextX>=n || nextY<0 || nextY>=m) {
                continue;
            }
            
            if (maze[nextX][nextY] != -1) {
                count = (count + dfs(m, n, nextX, nextY)) % 1000000007;
            }
        }
        
        dp[x][y] = count;
        
        return count;
    }
}