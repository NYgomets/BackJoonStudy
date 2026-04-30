import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i : moves) {
            int idx = i-1;
            
            int idol = 0;
            for (int j=0; j<board.length; j++) {
                if (board[j][idx] != 0) {
                    idol = board[j][idx];
                    board[j][idx] = 0;
                    break;
                }
            }
            
            if (idol == 0) {
                continue;
            }
            
            if (stack.isEmpty()) {
                stack.push(idol);
            } else {  
                int peek = stack.peek();
                if (peek == idol) {
                    stack.pop();
                    answer += 2;
                } else {
                    stack.push(idol);
                }
            }
        }
        
        return answer;
    }
}