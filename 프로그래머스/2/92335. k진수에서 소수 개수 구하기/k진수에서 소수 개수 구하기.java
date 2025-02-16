import java.util.*;

class Solution {
    public int solution(int n, int k) {
        String num = change(n, k);
        
        int result = 0;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<num.length(); i++) {
            char check = num.charAt(i);
            if (check != '0') {
                sb.append(check);
            }
            
            if (check == '0' && sb.length() != 0) {
                if (find(sb)) {
                    result ++;
                }
                sb = new StringBuilder();
            }
        }
        
        if (sb.length() != 0) {
            if (find(sb)) {
                result++;
            }
        }
        
        return result;
    }
    
    public boolean find(StringBuilder sb) {
        long num = Long.parseLong(sb.toString());
        
        if (num<2) {
            return false;
        }
        
        for (int i=2; i<=Math.sqrt(num); i++) {
            if (num%i == 0) {
                return false;
            }
        }
        
        return true;
    }
        
    public String change(int n, int k) {
        if (n==0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while(n>0) {
            sb.insert(0, n%k);
            n /= k;
        }
        
        return sb.toString();
    }
}