import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2-o1);
        for (String s : operations) {
            String[] arr = s.split(" ");
            String input = arr[0];
            int num = Integer.parseInt(arr[1]);
            if (input.equals("I")) {
                minHeap.add(num);
                maxHeap.add(num);
            } else if (input.equals("D")) {
                if (num == -1 && !minHeap.isEmpty()) {
                    int check = minHeap.poll();
                    maxHeap.remove(check);
                } else if (num == 1 && !maxHeap.isEmpty()) {
                    int check = maxHeap.poll();
                    minHeap.remove(check);
                }
            }
        }
        
        int[] result = {0, 0};
        if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
            int min = minHeap.peek();
            int max = maxHeap.peek();
            result[0] = max;
            result[1] = min;
        }
        
        return result;
    }
}