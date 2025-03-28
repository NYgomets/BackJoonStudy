import java.util.*;

class Solution {
    static class Node {
        int weight;
        int distance;
        public Node(int weight, int distance) {
            this.weight = weight;
            this.distance = distance;
        }
        
        public void setDis(int distance) {
            this.distance = distance;
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Node> inBridge = new LinkedList<>();
        for (int i : truck_weights) {
            inBridge.add(new Node(i, 0));
        }
        Queue<Node> bridge = new LinkedList<>();
        Queue<Node> outBridge = new LinkedList<>();
        int answer = 0;
        while (true) {
            if (outBridge.size() == truck_weights.length) {
                break;
            }
            
            out(bridge_length, bridge, outBridge);
            in(weight, bridge, inBridge);
            answer++;
        }
        return answer;
    }
    
    public void in(int weight, Queue<Node> bridge, Queue<Node> inBridge) {
        if (inBridge.isEmpty()) {
            return;
        }
        
        int sum = 0;
        for (Node node : bridge) {
            sum += node.weight;
        }
        
        Node in = inBridge.peek();
        int inWeight = in.weight;
        int inDis = in.distance;
        
        if (weight >= sum+inWeight) {
            inBridge.poll();
            in.setDis(inDis+1);
            bridge.add(in);
        }
    }
    
    public void out(int length, Queue<Node> bridge, Queue<Node> outBridge) {
        Iterator<Node> itr = bridge.iterator();
        while(itr.hasNext()) {
            Node node = itr.next();
            int dis = node.distance + 1;
            if (dis > length) {
                itr.remove();
                outBridge.add(node);
            } else {
                node.setDis(dis);
            }
        }
    }
}