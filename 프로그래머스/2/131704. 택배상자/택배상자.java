import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        int current = 1;
        for (int check : order) {
            while (current <= check) {
                stack.push(current);
                current++;
            }
            
            if (stack.peek() == check) {
                answer++;
                stack.pop();
            } else {
                break;
            }
        }
        
        return answer;
    }
}