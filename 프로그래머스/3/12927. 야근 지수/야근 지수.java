import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int i : works) {
            queue.add(i);
        }
        while (n>0) {
            int check = queue.poll();
            if (check == 0) {
                break;
            }
            n--;
            check--;
            queue.add(check);
        }
        
        long result = 0;
        if (queue.isEmpty()) {
            return result;
        }
        
        while (!queue.isEmpty()) {
            int check = queue.poll();
            result += Math.pow(check, 2);
        }
        return result;
    }
}