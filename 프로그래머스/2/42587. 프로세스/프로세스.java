import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i=0; i<priorities.length; i++) {
            queue.add(new int[]{i, priorities[i]});
        }
        int answer = 0;
        while(!queue.isEmpty()) {
            int[] poll = queue.poll();
            int num = poll[1];
            boolean find = false;
            for (int[] arr : queue) {
                if (num < arr[1]) {
                    queue.add(poll);
                    find = true;
                    break;
                }
            }
            if (!find) {
                answer++;
                if (poll[0] == location) {
                    break;
                }
            }
        }
        
        return answer;
    }
}