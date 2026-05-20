import java.util.*;

class Solution {
    static Set<String> result = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        Set<String> set = new HashSet<>();
        List<String>[] adjList = new ArrayList[banned_id.length];
        for (int i=0; i<banned_id.length; i++) {
            adjList[i] = new ArrayList<>();
        }
        int i=0;
        for (String ban : banned_id) {
            int num = 0;
            
            for (String user : user_id) {
                boolean yes = check(ban, user);
                if (yes) {
                    adjList[i].add(user);
                }
            }
            
            i++;
        }
        
        
        dfs(0, adjList, new HashSet<>());
        
        return result.size();
    }
    
    static public void dfs(int idx, List<String>[] adjList, Set<String> set) {
        if (idx == adjList.length) {
            List<String> list = new ArrayList<>(set);
            Collections.sort(list);
            result.add(String.join(",", list));
            return;
        }
        
        for (String s : adjList[idx]) {
            if (set.contains(s)) {
                continue;
            }
            set.add(s);
            dfs(idx+1, adjList, set);
            set.remove(s);
        }
    }
    
    static public boolean check(String ban, String user) {
        if (ban.length() != user.length()) {
            return false;
        }
        
        for (int i=0; i<ban.length(); i++) {
            char b = ban.charAt(i);
            char u = user.charAt(i);
            
            if (b == '*') {
                continue;
            } else {
                if (b != u) {
                    return false;
                } else {
                    continue;
                }
            }
        }
        
        return true;
    }
}