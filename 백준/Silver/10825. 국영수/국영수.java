import java.io.*;
import java.util.*;

public class Main {
    static Queue<Node> queue;
    static class Node {
        String name;
        int korean;
        int english;
        int math;

        public Node(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.korean == o2.korean) {
                    if (o1.english == o2.english) {
                        if (o1.math == o2.math) {
                            return o1.name.compareTo(o2.name);
                        } else  {
                            return o2.math-o1.math;
                        }
                    } else {
                        return o1.english-o2.english;
                    }
                } else {
                    return o2.korean-o1.korean;
                }
            }
        });
        StringTokenizer st;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            queue.add(new Node(name, korean, english, math));
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.poll().name);
        }
    }
}