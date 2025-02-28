import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zero = 0;
        for (int i=0; i<lottos.length; i++) {
            if (lottos[i] == 0) {
                lottos[i] = 46;
                zero++;
            }
        }
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        int count = 0;
        for (int i=0; i<lottos.length; i++) {
            for (int j=0; j<win_nums.length; j++) {
                if (lottos[i]==win_nums[j]) {
                    count++;
                    break;
                }
            }
        }
        
        int max = 0;
        int min = 0;
        for (int i=1; i<=6; i++) {
            if (7-i == count) {
                min = i;
            }
        }
        if (min == 0) {
            min = 6;
        }
        max = min-zero;
        if (max == 0) {
            max = 1;
        }
        
        return new int[]{max, min};
    }
}