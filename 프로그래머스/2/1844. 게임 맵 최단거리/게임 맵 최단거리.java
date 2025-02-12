import java.util.*;

class Solution {
    static boolean[][] visited;
    static int[] directionX = {-1, 1, 0, 0};
    static int[] directionY = {0, 0, -1, 1};
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        int result = bfs(maps, 0, 0, 1);
        return result;
    }
    
    public int bfs(int[][] maps, int x, int y, int count) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, count});
        
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];
            int current = poll[2];
            
            if (visited[currentX][currentY]) {
                continue;
            }
            visited[currentX][currentY] = true;
            
            if (currentX == maps.length-1 && currentY == maps[0].length-1) {
                return current;
            }
            
            for (int i=0; i<4; i++) {
                int nextX = currentX + directionX[i];
                int nextY = currentY + directionY[i];
                
                if (nextX<0 || nextX>=maps.length || nextY<0 || nextY>=maps[0].length) {
                    continue;
                }
                
                if (maps[nextX][nextY] == 1) {
                    queue.add(new int[]{nextX, nextY, current+1});
                }
            }
        }
        return -1;
    }
}