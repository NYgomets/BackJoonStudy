import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new LinkedList<>();
        for (int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            list.add(num);
        }

        Collections.sort(list, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }
}