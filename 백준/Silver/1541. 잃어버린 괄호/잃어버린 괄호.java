import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String givenRow = br.readLine();
        StringTokenizer st = new StringTokenizer(givenRow, "-");
        Queue<String> queue = new LinkedList<>();
        while (st.hasMoreTokens()) {
            queue.add(st.nextToken());
        }

        Queue<Integer> integerQueue = new LinkedList<>();
        int queSize = queue.size();
        for (int i=0; i<queSize; i++) {
            String poll = queue.poll();
            if (poll.contains("+")) {
                int check = 0;
                String[] split = poll.split("\\+");
                for (int j=0; j<split.length; j++) {
                    check += Integer.parseInt(split[j]);
                }
                integerQueue.add(check);
            } else {
                integerQueue.add(Integer.parseInt(poll));
            }
        }

        int intqueSize = integerQueue.size();
        int result = integerQueue.poll();
        for (int k=1; k<intqueSize; k++) {
            result -= integerQueue.poll();
        }

        System.out.println(result);
    }
}