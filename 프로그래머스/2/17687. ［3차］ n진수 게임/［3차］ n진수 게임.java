class Solution {
    static StringBuilder sb = new StringBuilder();
    public String solution(int n, int t, int m, int p) {
        int max = t*m;
        int start = 0;
        while (sb.length() < max) {
            String str = change(start, n);
            appending(str, max);
            start++;
        }
        
        String check = sb.toString();
        StringBuilder result = new StringBuilder();
        for (int i=0; i<check.length(); i++) {
            if (i%m == p-1) {
                result.append(check.charAt(i));
            }
        }
        
        return result.toString();
    }
    
    public void appending(String str, int max) {
        for (int i=0; i<str.length(); i++) {
            if (sb.length()<max) {
                sb.append(str.charAt(i));
            }
        }
    }
    
    public String change(int start, int n) {
        if (start == 0) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        while(start>0) {
            char digit = Character.forDigit(start%n, n);
            sb.insert(0, Character.toUpperCase(digit));
            start /= n;
        }
        
        return sb.toString();
    }
}