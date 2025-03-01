class Solution {
    public int solution(String s) {
        int answer = 0;
        int same = 0;
        int different = 0;
        char start = '\0';
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (same == 0 && different == 0) {
                same++;
                start = c;
            } else {
                if (start == c) {
                    same++;
                } else {
                    different++;
                }
            }
            if (same == different) {
                answer++;
                same = 0;
                different = 0;
            }
        }
        
        if (same != 0 || different != 0) {
            answer++;
        }
        return answer;
    }
}