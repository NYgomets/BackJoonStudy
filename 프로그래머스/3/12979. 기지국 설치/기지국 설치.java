import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int cover = 2*w+1;
        int last = 0;
        for (int station : stations) {
            int left = station-w;
            if (last+1<left) {
                int gap = left - (last+1);
                answer += (gap + cover - 1) / cover;
            }
            last = station+w;
        }
        
        if (last+1<=n) {
            int gap = n - last;
            answer += (gap + cover-1)/cover;
        }
        return answer;
    }
}