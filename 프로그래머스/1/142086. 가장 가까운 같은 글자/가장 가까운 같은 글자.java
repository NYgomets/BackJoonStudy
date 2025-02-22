import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] result = new int[s.length()];
        int[] alpha = new int[26];
        Arrays.fill(alpha, -1);
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (alpha[c-'a'] == -1) {
                result[i] = -1;
                alpha[c-'a'] = i;
            } else {
                result[i] = i-alpha[c-'a'];
                alpha[c-'a'] = i;
            }
        }
        
        return result;
    }
}