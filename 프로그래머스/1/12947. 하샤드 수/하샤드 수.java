class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        String s = String.valueOf(x);
        int num = 0;
        for (int i=0; i<s.length(); i++) {
            num += Integer.parseInt(s.substring(i, i+1));
        }
        
        if (x%num != 0) {
            answer = false;
        }
        
        return answer;
    }
}