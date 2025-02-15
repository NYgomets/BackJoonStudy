import java.util.*;

class Solution {
    static int[][] maze = new int[11][11];
    static String[] dir;
    static Set<String> set = new HashSet<>();
    public int solution(String dirs) {
        dir = new String[dirs.length()];
        for (int i=0; i<dirs.length(); i++) {
            dir[i] = dirs.substring(i, i+1);
        }
        return bfs(5, 5, 0);
    }
    
    public int bfs(int x, int y, int d) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, d});
        int count = 0;
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int currentX = poll[0];
            int currentY = poll[1];
            int currentD = poll[2];
            
            if (currentD >= dir.length) {
                break;
            }
            
            int nextX = currentX;
            int nextY = currentY;
            String direction = dir[currentD];
            if (direction.equals("U")) {
                nextX -= 1;
            } else if (direction.equals("D")) {
                nextX += 1;
            } else if (direction.equals("R")) {
                nextY += 1;
            } else if (direction.equals("L")) {
                nextY -= 1;
            }
            
            if (nextX>=0 && nextX<=10 && nextY>=0 && nextY<=10) {
                String path1 = currentX + "," + currentY + "->" + nextX + "," + nextY;
                String path2 = nextX + "," + nextY + "->" + currentX + "," + currentY;
                if (!set.contains(path1)) {
                    set.add(path1);
                    set.add(path2);
                    count++;
                }
                queue.add(new int[]{nextX, nextY, currentD+1});
            } else {
                queue.add(new int[]{currentX, currentY, currentD+1});
            }
        }
        
        return count;
    }
}