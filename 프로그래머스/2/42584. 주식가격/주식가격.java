import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i=0; i<prices.length; i++) {
            int count = 0;
            int current = prices[i];
            for (int j=i+1; j<prices.length; j++) {
                count++;
                if (current > prices[j]) {
                    break;
                }
            }
            answer[i] = count;
        }
        return answer;
    }
}
