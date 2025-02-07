import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int length = citations.length;
        for (int i = 0; i < length; i++) {
            int hIndex = length - i;
            if (citations[i] >= hIndex) {
                return hIndex;
            }
        }
        return 0;
    }
}
