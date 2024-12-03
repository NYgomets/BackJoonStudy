import java.io.*;
import java.util.*;

public class Main {
    static int[] arr = new int[4];
    static class Node {
        int start;
        String path;

        public Node(int start, String path) {
            this.start = start;
            this.path = path;
        }

        public int getStart() {
            return start;
        }

        public String getPath() {
            return path;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int l=0; l<t; l++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            cal(first, second);
        }
    }

    private static void cal(int first, int second) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(first, ""));
        Set<Integer> visited = new HashSet<>();
        visited.add(first);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.getStart() == second) {
                System.out.println(current.getPath());
                return;
            }

            int next = functionD(current.getStart());
            if (!visited.contains(next)) {
                visited.add(next);
                queue.add(new Node(next, current.getPath()+"D"));
            }

            next = functionS(current.getStart());
            if (!visited.contains(next)) {
                visited.add(next);
                queue.add(new Node(next, current.getPath()+"S"));
            }

            next = functionR(current.getStart());
            if (!visited.contains(next)) {
                visited.add(next);
                queue.add(new Node(next, current.getPath()+"R"));
            }

            next = functionL(current.getStart());
            if (!visited.contains(next)) {
                visited.add(next);
                queue.add(new Node(next, current.getPath()+"L"));
            }
        }
    }

    public static int functionD(int start) {
        return (start*2) % 10000;
    }

    public static int functionS(int start) {
        return start == 0 ? 9999 : start-1;
    }

    public static int functionL(int start) {
        formatting(start);
        int prev = arr[0];
        for (int i=1; i<4; i++) {
            arr[i-1] = arr[i];
        }
        arr[3] = prev;

        return toNumber();
    }

    public static int functionR(int start) {
        formatting(start);
        int prev = arr[3];
        for (int i=3; i>0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = prev;

        return toNumber();
    }

    private static int toNumber() {
        return arr[0] * 1000 + arr[1] * 100 + arr[2] * 10 + arr[3];
    }

    private static void formatting(int start) {
        arr[0] = start/1000;
        arr[1] = (start%1000)/100;
        arr[2] = (start%100)/10;
        arr[3] = start%10;
    }
}
