import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<progresses.length; i++) {
            int remain = 100-progresses[i];
            if (remain % speeds[i] == 0) {
                queue.add(remain/speeds[i]);
            } else {
                queue.add(remain/speeds[i]+1);
            }
        }
        
        List<Integer> list = new ArrayList<>();
        int length = queue.size();
        int max = 0;
        int count = 0;
        for (int i=0; i<length; i++) {
            int poll = queue.poll();
            if (max < poll)  {
                if (i != 0) {
                    list.add(count);
                }
                max = poll;
                count = 1;
            } else {
                count++;
            }
        }
        list.add(count);
        int[] result = new int[list.size()];
        for (int i=0; i<result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}