class Solution {
    static int one = 0;
    static int zero = 0;
    public int[] solution(int[][] maze) {
        allCheck(maze);
        return new int[]{zero, one};
    }
    
    public void allCheck(int[][] maze) {
        if (maze.length == 1) {
            if (maze[0][0] == 0) {
                zero++;
            } else {
                one++;
            }
            return;
        }
        
        if (checkNum(maze)) {
            if (maze[0][0] == 0) {
                zero++;
            } else {
                one++;
            }
        } else {
            dividedMaze(maze);
        }
    }
    
    public void dividedMaze(int[][] maze) {
        int n = maze.length;
        int m = maze[0].length;
        int[][] first = new int[n/2][m/2];
        for (int i=0; i<n/2; i++) {
            for (int j=0; j<m/2; j++) {
                first[i][j] = maze[i][j];
            }
        }
        allCheck(first);
        
        int[][] second = new int[n/2][m/2];
        for (int i=0; i<n/2; i++) {
            for (int j=m/2; j<m; j++) {
                second[i][j - m/2] = maze[i][j];
            }
        }
        allCheck(second);
        
        int[][] third = new int[n/2][m/2];
        for (int i=n/2; i<n; i++) {
            for (int j=0; j<m/2; j++) {
                third[i - n/2][j] = maze[i][j];
            }
        }
        allCheck(third);
        
        int[][] fourth = new int[n/2][m/2];
        for (int i=n/2; i<n; i++) {
            for (int j=m/2; j<m; j++) {
                fourth[i - n/2][j - m/2] = maze[i][j];
            }
        }
        allCheck(fourth);
        
    }
    
    public boolean checkNum(int[][] maze) {
        for (int i=0; i<maze.length; i++) {
            for (int j=0; j<maze[0].length; j++) {
                if (maze[0][0] != maze[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}