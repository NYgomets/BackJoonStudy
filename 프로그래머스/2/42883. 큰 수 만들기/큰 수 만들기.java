class Solution {
    public String solution(String number, int k) {
        String answer = "";
        int start = number.length();
        int left = 0;
        int pick = start - k;
        
        for (int i=0; i<pick; i++) {
            int right = start - (pick - i);
            int numIdx = findNum(number, left, right);
            answer += number.charAt(numIdx);
            left = numIdx+1;
        }
        
        return answer;
    }
    
    static public int findNum(String number, int left, int right) {
        int idx = left;
        int max = 0;
        
        for (int i=left; i<=right; i++) {
            int check = number.charAt(i) - '0';
            
            if (max < check) {
                max = check;
                idx = i;
            }
        }
        
        return idx;
    }
}