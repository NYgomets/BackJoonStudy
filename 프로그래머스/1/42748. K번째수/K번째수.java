import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] result = new int[commands.length];
        int idx = 0;
        for (int[] command : commands) {
            List<Integer> list = new ArrayList<>();
            int i = command[0]-1;
            int j = command[1]-1;
            int k = command[2]-1;
            for (int start=i; start<=j; start++) {
                list.add(array[start]);
            }
            Collections.sort(list);
            result[idx++] = list.get(k);
        }
        return result;
    }
}