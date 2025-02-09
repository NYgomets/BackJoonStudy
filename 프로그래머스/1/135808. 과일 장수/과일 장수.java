import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int answer = 0;
        int start = score.length-1;
        while (start-m+1 >= 0) {
            start = start-m+1;
            answer += (score[start]*m);
            start--;
        } 
        
        return answer;
    }
}