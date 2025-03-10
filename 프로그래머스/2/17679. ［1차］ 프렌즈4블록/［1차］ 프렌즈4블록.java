class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] maze = new char[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                maze[i][j] = board[i].charAt(j);
            }
        }
        
        int count = 0;
        while(true) {
            boolean check = false;
            boolean[][] visited = new boolean[m][n];
            for (int i=0; i<m-1; i++) {
                for (int j=0; j<n-1; j++) {
                    char current = maze[i][j];
                    if (current != ' ' && current == maze[i][j+1] && current == maze[i+1][j] && current == maze[i+1][j+1]) {
                        visited[i][j] = visited[i][j+1] = visited[i+1][j] = visited[i+1][j+1] = true;
                        check = true;
                    }
                }
            }
            
            if (!check) {
                break;
            }
            
            for (int i=0; i<m; i++) {
                for (int j=0; j<n; j++) {
                    if (visited[i][j]) {
                        count++;
                        maze[i][j] = ' ';
                    }
                }
            }
            
            for (int j=0; j<n; j++) {
                int emptyRow = m-1;
                for (int i=m-1; i>=0; i--) {
                    if (maze[i][j] != ' ') {
                        char temp = maze[i][j];
                        maze[i][j] = ' ';
                        maze[emptyRow][j] = temp;
                        emptyRow--;
                    }
                }
            }
        }
        return count;
    }
}