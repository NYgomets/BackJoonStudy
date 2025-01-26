class Solution {
    public boolean solution(String s) {
        return check(s);
    }
    
    public boolean check(String s) {
        if (s.length() != 4 && s.length() != 6) {
            return false;
        }
        
        for (int i=0; i<s.length(); i++) {
            int num = s.charAt(i)-'0';
            if (num < 0 || num > 9 ) {
                return false;
            }
        }
        
        return true;
    }
}