import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<String> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            String check = s.substring(i, i+1);
            if (check.equals("(")) {
                stack.push(check);
            } else if (check.equals(")")) {
                if (stack.isEmpty()) {
                    answer = false;
                    break;
                }
                
                String str = stack.pop();
                if (!str.equals("(")) {
                    answer = false;
                    break;
                }
            }
        }
        
        if (!stack.isEmpty()) {
            answer = false;
        }
        
        return answer;
    }
}