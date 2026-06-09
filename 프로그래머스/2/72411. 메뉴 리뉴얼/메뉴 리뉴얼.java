import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        Map<String, Integer> map = new HashMap<>();
        for (String order : orders) {
            char[] cArr = order.toCharArray();
            Arrays.sort(cArr);
            for (int num : course) {
                dfs(0, "", num, cArr, map);
            }
        }
        
        Map<Integer, Integer> maxMap = new HashMap<>();
        for (String menu : map.keySet()) {
            int cnt = map.get(menu);
            if (cnt < 2) {
                continue;
            }
            int len = menu.length();
            
            maxMap.put(len, Math.max(maxMap.getOrDefault(len, 0), cnt));
        }
        
        List<String> list = new ArrayList<>();
        for (String menu : map.keySet()) {
            int cnt = map.get(menu);
            if (cnt < 2) {
                continue;
            }
            int len = menu.length();
            if (maxMap.get(len) == cnt) {
                list.add(menu);
            }
        }
        
        Collections.sort(list);
        return list.toArray(String[]::new);
    }
    
    static public void dfs(int idx, String cur, int num, char[] cArr, Map<String, Integer> map) {
        if (cur.length() == num) {
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            return;
        }
        
        for (int i=idx; i<cArr.length; i++) {
            dfs(i+1, cur+cArr[i], num, cArr, map);
        }
    }
}