import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        int result = 1;
        int last = routes[0][1];
        for (int i=1; i<routes.length; i++) {
            if (routes[i][0] <= last) {
                continue;
            } else {
                result++;
                last = routes[i][1];
            }
        }
        
        return result;
    }
}