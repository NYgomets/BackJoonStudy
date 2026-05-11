import java.util.*;

class Solution {
    static class Node {
        int start;
        int end;
        
        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public int solution(String[][] book_time) {
        Node[] nodes = new Node[book_time.length];
        for (int i=0; i<book_time.length; i++) {
            String[] first = book_time[i][0].split(":");
            String[] second = book_time[i][1].split(":");
            
            int start = Integer.parseInt(first[0])*60+Integer.parseInt(first[1]);
            int end = Integer.parseInt(second[0])*60+Integer.parseInt(second[1])+10;
            
            nodes[i] = new Node(start, end);
        }
        
        Arrays.sort(nodes, (o1, o2) -> o1.start - o2.start);
        
        Queue<Integer> queue = new PriorityQueue<>();
        queue.add(nodes[0].end);
        
        for (int i=1; i<book_time.length; i++) {
            if (nodes[i].start >= queue.peek()) {
                queue.poll();
                queue.add(nodes[i].end);
            } else {
                queue.add(nodes[i].end);
            }
        }
        
        return queue.size();
    }
}