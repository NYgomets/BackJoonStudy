import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int length = citations.length;
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (citations[i] >= length-i) {
                result = Math.max(result, length-i);
            }
        }
        return result;
    }
}
