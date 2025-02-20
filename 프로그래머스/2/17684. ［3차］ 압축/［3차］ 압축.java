import java.util.*;

class Solution {
    static Map<String, Integer> map = new HashMap<>();
    static List<Integer> list = new ArrayList<>();
    static int num = 27;
    public int[] solution(String msg) {
        for (char i='A'; i<='Z'; i++) {
            map.put(String.valueOf(i), i-'A'+1);
        }
        
        String current = "";
        int last = -1;
        for (int i=0; i<msg.length(); i++) {
            String check = String.valueOf(msg.charAt(i)); 
            current += check;
            if (map.containsKey(current)) {
                last = map.get(current);
            } else {
                list.add(last);
                map.put(current, num);
                num++;
                current = check;
                last = map.get(current);
            }
        }
        list.add(last);
        int[] result = new int[list.size()];
        for (int i=0; i<result.length; i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}