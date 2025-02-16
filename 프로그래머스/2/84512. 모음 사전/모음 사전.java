import java.util.*;

class Solution {
    static String[] arr = {"A", "E", "I", "O", "U"};
    static List<String> list = new ArrayList<>();
    public int solution(String word) {
        dfs("", 0);
        int count = 0;
        for (String str : list) {
            count++;
            if (word.equals(str)) {
                break;
            }
        }
        return count;
    }
    
    public void dfs(String current, int idx) {
        if (idx == 5) {
            return;
        }
        
        for (String s : arr) {
            String check = current+s;
            list.add(check);
            dfs(check, idx+1);
        }
    }
}