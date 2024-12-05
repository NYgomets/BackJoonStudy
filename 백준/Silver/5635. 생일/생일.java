import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        String name;
        int day;
        int month;
        int year;

        public Node(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Node> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int dd = Integer.parseInt(st.nextToken());
            int mm = Integer.parseInt(st.nextToken());
            int yy = Integer.parseInt(st.nextToken());
            list.add(new Node(name, dd, mm, yy));
        }
        list.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.year == o2.year) {
                    if (o1.month == o2.month) {
                        return o1.day - o2.day;
                    } else {
                        return o1.month - o2.month;
                    }
                } else {
                    return o1.year - o2.year;
                }
            }
        });

        System.out.println(list.get(n-1).name);
        System.out.println(list.get(0).name);
    }
}