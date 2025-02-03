import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int boat = 0;
        int start = 0;
        Arrays.sort(people);
        int end = people.length-1;
        while (start <= end) {
            int sum = people[start]+people[end];
            
            if (sum <= limit) {
                start++;
            }
            end--;
            boat++;
        }
        return boat;
    }
}