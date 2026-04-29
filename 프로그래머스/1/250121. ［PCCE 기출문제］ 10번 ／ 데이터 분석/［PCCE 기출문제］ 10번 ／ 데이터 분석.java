import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int check;
        if (ext.equals("code")) {
            check = 0;
        } else if (ext.equals("date")) {
            check = 1;
        } else if (ext.equals("maximum")) {
            check = 2;
        } else {
            check = 3;
        }
        Arrays.sort(data, (o1, o2) -> o1[check] - o2[check]);
        
        List<int[]> list = new ArrayList<>();
        for (int i=0; i<data.length; i++) {
            if (data[i][check] < val_ext) {
                list.add(data[i]);
            }
        }
        
        int ck;
        if (sort_by.equals("code")) {
            ck = 0;
        } else if (sort_by.equals("date")) {
            ck = 1;
        } else if (sort_by.equals("maximum")) {
            ck = 2;
        } else {
            ck = 3;
        }
        
        Collections.sort(list, (o1, o2) -> o1[ck] - o2[ck]);
        
        int[][] answer = new int[list.size()][];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}