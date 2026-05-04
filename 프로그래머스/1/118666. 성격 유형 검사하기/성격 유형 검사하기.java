class Solution {
    public String solution(String[] survey, int[] choices) {
        int R = 0;
        int T = 0;
        int C = 0;
        int F = 0;
        int J = 0;
        int M = 0;
        int A = 0;
        int N = 0;
        
        for (int i=0; i<survey.length; i++) {
            String s = survey[i];
            char first = s.charAt(0);
            char second = s.charAt(1);
            
            int c = choices[i];
            
            if (c < 4) {
                if (first == 'R') {
                    R += (4-c);
                } else if (first == 'T') {
                    T += (4-c);
                } else if (first == 'C') {
                    C += (4-c);
                } else if (first == 'F') {
                    F += (4-c);
                } else if (first == 'J') {
                    J += (4-c);
                } else if (first == 'M') {
                    M += (4-c);
                } else if (first == 'A') {
                    A += (4-c);
                } else if (first == 'N') {
                    N += (4-c);
                }
            } else if (c > 4) {
                if (second == 'R') {
                    R += (c-4);
                } else if (second == 'T') {
                    T += (c-4);
                } else if (second == 'C') {
                    C += (c-4);
                } else if (second == 'F') {
                    F += (c-4);
                } else if (second == 'J') {
                    J += (c-4);
                } else if (second == 'M') {
                    M += (c-4);
                } else if (second == 'A') {
                    A += (c-4);
                } else if (second == 'N') {
                    N += (c-4);
                }
            }
        }
            String answer = "";
            
            answer += (R >= T) ? "R" : "T";
            answer += (C >= F) ? "C" : "F";
            answer += (J >= M) ? "J" : "M";
            answer += (A >= N) ? "A" : "N";
            
            return answer;
    }
}