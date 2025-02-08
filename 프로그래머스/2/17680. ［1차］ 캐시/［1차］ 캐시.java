import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) {
            return cities.length*5;
        }
        
        Queue<String> queue = new LinkedList<>();
        int answer = 0;
        
        for (String city : cities) {
            city = city.toLowerCase();
            if (queue.contains(city)) {
                answer += 1;
                queue.remove(city);
                queue.add(city);
                
            } else {
                answer += 5;
                if (queue.size() >= cacheSize) {
                    queue.poll();
                }
                queue.add(city);
            }
        }
        
        return answer;
    }
}