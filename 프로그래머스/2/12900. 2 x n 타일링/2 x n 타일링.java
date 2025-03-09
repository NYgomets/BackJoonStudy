import java.util.*;

class Solution {
    public int solution(int n) {
        int[] result = new int[n+1];
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else if (n == 3) {
            return 3;
        }
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;
        for (int i=4; i<=n; i++) {
            result[i] = (result[i-2]+result[i-1])%1000000007;
        }
        return result[n];
    }
}