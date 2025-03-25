import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for (int i : numbers) {
            list.add(i);
        }
        list.sort((o1, o2) -> {
            String first = ""+o1+o2;
            String second = ""+o2+o1;
            return Integer.compare(Integer.parseInt(second), Integer.parseInt(first));
        });
        
        StringBuilder sb = new StringBuilder();
        for (int i : list) {
            sb.append(i).append("");
        }
        
        String result = sb.toString();
        
        if (result.startsWith("0")) {
            return "0";
        }
        
        return result;
    }
}