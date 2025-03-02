import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        return bfs(x, y, n);
    }
    
    public int bfs (int x, int y, int n) {
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        Set<Integer> visited = new HashSet<>();
        queue.add(new int[]{x, 0});
        
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int current = poll[0];
            int count = poll[1];
            
            if (current == y) {
                return count;
            } else if (current > y || visited.contains(current)) {
                continue;
            }
            
            visited.add(current);
            queue.add(new int[]{current+n, count+1});
            queue.add(new int[]{current*2, count+1});
            queue.add(new int[]{current*3, count+1});
        }
        
        return -1;
    }
}