import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Boolean> map = new TreeMap<>((o1, o2) -> o2.compareTo(o1));

        for (int i=0; i<N; i++) {
            String[] split = br.readLine().split(" ", 2);
            if (split[1].equals("enter")) {
                map.put(split[0], true);
            } else if (split[1].equals("leave")) {
                map.remove(split[0]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String name : map.keySet()) {
            sb.append(name).append("\n");
        }

        System.out.println(sb);

    }
}