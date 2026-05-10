class Solution {
    public int[] solution(int n) {
        int length = 0;
        for (int i=n; i>0; i--) {
            length += i;
        }
        int[] answer = new int[length];
        
        int[] dy = {1, 0, -1};
        int[] dx = {0, 1, -1};
        int y = -1;
        int x = 0;
        int dir = 0;
        int num = 1;
        int[][] maze = new int[n][n];
        while (num <= length) {
            y += dy[dir];
            x += dx[dir];
            maze[y][x] = num++;
            
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            
            if (ny<0 || ny>=n || nx<0 || nx>=n || maze[ny][nx] != 0) {
                dir = (dir+1)%3;
            }
            
        }
        
        int arr = 0;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (maze[i][j] != 0) {
                    answer[arr++] = maze[i][j];
                }
            }
        }
        return answer;
    }
}