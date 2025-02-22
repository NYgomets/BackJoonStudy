import java.util.*;

class Solution {
    static boolean[] visited;
    static class Node {
        String current;
        int count;
        
        public Node(String current, int count) {
            this.current = current;
            this.count = count;
        }
    }
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        int answer = bfs(begin, target, words);
        return answer;
    }
    
    public int bfs(String current, String target, String[] words) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(current, 0));
        
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int currentCount = node.count;
            String currentStr = node.current;
            
            if (currentStr.equals(target)) {
                return currentCount;
            }
            
            for (int i=0; i<words.length; i++) {
                if (!visited[i] && check(currentStr, words[i])) {
                    visited[i] = true;
                    queue.add(new Node(words[i], currentCount+1));
                }
            }
        }
        return 0;
    }
    
    public boolean check(String first, String second) {
        int diff = 0;
        for (int i=0; i<first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                diff++;
            }
        }
        
        if (diff <= 1) {
            return true;
        } else {
            return false;
        }
    }
}