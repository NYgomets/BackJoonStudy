import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<String> queue = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));
        String string = br.readLine();
        for (int i=0; i<string.length(); i++) {
            queue.add(string.substring(i));
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
