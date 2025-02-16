import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int max = Math.max(wallet[0], wallet[1]);
        int min = Math.min(wallet[0], wallet[1]);
        wallet[0] = max;
        wallet[1] = min;
        
        int result = 0;
        while (true) {
            bill = sorting(bill);
            if (bill[0]<=wallet[0] && bill[1]<=wallet[1]) {
                break;
            }
            result++;
            bill[0] = bill[0]/2;
        }
        return result;
    }
    
    public int[] sorting(int[] bill) {
        int max = Math.max(bill[0], bill[1]);
        int min = Math.min(bill[0], bill[1]);
        bill[0] = max;
        bill[1] = min;
        return bill;
        
    }
}