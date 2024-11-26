import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<Node> list;
    static class Node {
        int first;
        int second;

        public Node(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int l=0; l<t; l++) {
            n = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            StringTokenizer st;
            for (int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.add(new Node(a, b));
            }

            list.sort(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return o1.getFirst()-o2.getFirst();
                }
            });


            int result = 1;
            int count = list.size();
            int prevSecond = list.get(0).getSecond();
            for (int i=1; i<count; i++) {
                if (list.get(i).getSecond() < prevSecond) {
                    result++;
                    prevSecond = list.get(i).getSecond();
                }
            }

            System.out.println(result);
        }
    }
}
