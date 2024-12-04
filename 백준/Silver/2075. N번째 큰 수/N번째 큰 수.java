import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new PriorityQueue<>();
        StringTokenizer st;
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                queue.add(Integer.parseInt(st.nextToken()));
                if (queue.size()>n) {
                    queue.poll();
                }
            }
        }

        System.out.println(queue.poll());
    }
}