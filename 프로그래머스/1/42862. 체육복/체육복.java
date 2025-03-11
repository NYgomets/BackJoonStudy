import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        List<Integer> first = new ArrayList<>();
        for (int i : lost) {
            first.add(i);
        }
        List<Integer> second = new ArrayList<>();
        for (int i : reserve) {
            if (first.contains(i)) {
                first.remove((Integer) (i));
                continue;
            }
            second.add(i);
        }
        
        int answer = n-first.size();
        for (int l : first) {
            if (second.contains(l-1)) {
                answer++;
                second.remove((Integer) (l-1));
            } else if (second.contains(l+1)) {
                answer++;
                second.remove((Integer) (l+1));
            }
        }
        return answer;
    }
}