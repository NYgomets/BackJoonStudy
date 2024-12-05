import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int grade;
        int idx;

        public Node(int grade, int idx) {
            this.grade = grade;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Node> list = new ArrayList<>();
        int sum = 0;
        for (int i=1; i<=8; i++) {
            list.add(new Node(Integer.parseInt(br.readLine()), i));
        }
        list.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.grade-o1.grade;
            }
        });

        int[] arr = new int[5];
        for (int i=0; i<5; i++) {
            Node node = list.get(i);
            sum += node.grade;
            arr[i] = node.idx;
        }
        System.out.println(sum);
        Arrays.sort(arr);
        for (int c : arr) {
            System.out.print(c + " ");
        }
    }
}