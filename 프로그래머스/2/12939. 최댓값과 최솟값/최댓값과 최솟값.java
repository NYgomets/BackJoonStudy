import java.util.*;

class Solution {
    public String solution(String s) {
        String[] sArr = s.split(" ");
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (String num : sArr) {
            min = Math.min(min, Integer.parseInt(num));
            max = Math.max(max, Integer.parseInt(num));
        }
        
        return min + " " + max;
    }
}