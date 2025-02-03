import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        int[] answer = {0, 0};
        String last = "";
        for (int i=0; i<words.length; i++) {
            if (set.contains(words[i])) {
                int person = (i%n)+1;
                int routine = (i/n)+1;
                answer[0] = person;
                answer[1] = routine;
                return answer;
            }
            
            if (!last.isEmpty() && last.charAt(last.length()-1) != words[i].charAt(0)) {
                int person = (i%n)+1;
                int routine = (i/n)+1;
                answer[0] = person;
                answer[1] = routine;
                return answer;
            }
            set.add(words[i]);
            last = words[i];
        }
        
        return answer;
    }
}