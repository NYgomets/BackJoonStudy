import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String s = String.valueOf(n);
        List<Long> list = new ArrayList<>();
        for (int i=0; i<s.length(); i++) {
            list.add(Long.parseLong(String.valueOf(s.charAt(i))));
        }
        Collections.sort(list, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for (long i : list) {
            sb.append(i);
        }
        
        answer = Long.parseLong(sb.toString());
        
        return answer;
    }
}