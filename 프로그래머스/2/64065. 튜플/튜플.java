import java.util.*;

class Solution {
    static Queue<Integer> queue;
    public int[] solution(String s) {
        queue = new LinkedList<>();
        String[] strArr = s.replaceAll("\\{", " ").replaceAll("\\}", " ").trim().split(" , ");
        Arrays.sort(strArr, (o1, o2) -> o1.length()-o2.length());
        
        for (String str : strArr) {
            check(str);
        }
        int[] result = new int[queue.size()];
        int idx = 0;
        while(!queue.isEmpty()) {
            result[idx++] = queue.poll();
        }
        
        return result;
    }
    
    public void check(String str) {
        String[] sArr = str.split(",");
        for (String s : sArr) {
            int num = Integer.parseInt(s);
            if (!queue.contains(num)) {
                queue.add(num);
            }
        }
    }
}