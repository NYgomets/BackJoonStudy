import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<arr.length; i++) {
            if (stack.isEmpty()) {
                stack.add(arr[i]);
            } else {
                int num = stack.peek();
                if (num != arr[i]) {
                    stack.add(arr[i]);
                }
            }
        }
        
        int[] result = new int[stack.size()];
        int idx = 0;
        for (int i : stack) {
            result[idx++] = i;
        }
        
        return result;
    }
}