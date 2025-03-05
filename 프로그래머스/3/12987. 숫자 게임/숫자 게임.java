import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer = 0;
        int idx = 0;
        for (int i=0; i<A.length; i++) {
            while (B.length>idx && B[idx]<=A[i]) {
                idx++;
            }
            if (idx<B.length) {
                answer++;
                idx++;
            }
        }
        return answer;
    }
}
