import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (String str : record) {
            String[] s = str.split(" ");
            String command = s[0];
            if (command.equals("Enter")) {
                String id = s[1];
                String nick = s[2];
                map.put(id, nick);
                list.add(id+"님이 들어왔습니다.");
            } else if (command.equals("Leave")) {
                String id = s[1];
                list.add(id+"님이 나갔습니다.");
            } else if (command.equals("Change")) {
                String id = s[1];
                String nick = s[2];
                map.put(id, nick);
            }
        }
        
        String[] result = new String[list.size()];
        for (int i=0; i<result.length; i++) {
            String message = list.get(i);
            String[] str = message.split("님");
            String id = str[0];
            String nick = map.get(id);
            result[i] = message.replace(id, nick);
        }
        return result;
    }
}