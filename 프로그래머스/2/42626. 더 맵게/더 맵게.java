import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i : scoville) {
            queue.add(i);
        }
        int answer = 0;
        while (true) {
            if (queue.isEmpty()) {
                return -1;
            } else if (queue.size()==1 && queue.peek()<K) {
                return -1;
            } else {
                int first = queue.poll();
                if (first>=K) {
                    break;
                }
                answer++;
                int second = queue.poll();
                queue.add(first+(second*2));
            }
        }
        return answer;
    }
}