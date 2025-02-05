import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        for (int k=0; k<s.length(); k++) {
            if (isValid(s)) {
                answer++;
            }
            s = rotate(s);
        }
        
        return answer;
    }
    
    public boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '[' || c == '(' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char pop = stack.pop();
                if (c==']' && pop!='[' || c==')' && pop!='(' || c=='}' && pop!='{') {
                    return false;
                }
            }
        }
        
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
    
    public String rotate(String str) {
        return str.substring(1)+str.charAt(0);
    }
}