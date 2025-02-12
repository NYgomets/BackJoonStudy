import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> first = new HashMap<>();
        Map<String, Integer> second = new HashMap<>();
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        for (int i=0; i<str1.length()-1; i++) {
            char f = str1.charAt(i);
            char s = str1.charAt(i+1);
            if (f<'a' || f>'z') {
                continue;
            }
            if (s<'a' || s>'z') {
                continue;
            }
            String str = ""+f+s;
            first.put(str, first.getOrDefault(str, 0)+1);
        }
        
        for (int i=0; i<str2.length()-1; i++) {
            char f = str2.charAt(i);
            char s = str2.charAt(i+1);
            if (f<'a' || f>'z') {
                continue;
            }
            if (s<'a' || s>'z') {
                continue;
            }
            String str = ""+f+s;
            second.put(str, second.getOrDefault(str, 0)+1);
        }
        
        if (first.size() == 0 && second.size() == 0) {
            return 65536;
        }
        
        int min = 0;
        int max = 0;
        
        for (String strF : first.keySet()) {
            if (second.containsKey(strF)) {
                min += Math.min(first.get(strF), second.get(strF));
            }
        }
        
        for (int i : first.values()) {
            max += i;
        }
        for (int i : second.values()) {
            max += i;
        }
        max -= min;
        double check = (double) min/max;
        return (int) (check*65536);
    }
}