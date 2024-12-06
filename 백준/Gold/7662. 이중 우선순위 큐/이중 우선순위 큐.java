import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int l=0; l<t; l++) {
            int n = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            StringTokenizer st;
            for (int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();
                int input = Integer.parseInt(st.nextToken());
                if (command.equals("I")) {
                    map.put(input, map.getOrDefault(input, 0)+1);
                } else if (command.equals("D")) {
                    if (map.isEmpty()) {
                        continue;
                    }
                    int num;
                    if (input == -1) {
                        num = map.firstKey();
                    } else {
                        num = map.lastKey();
                    }
                    if (map.get(num) >= 2) {
                        map.put(num, map.get(num)-1);
                    } else {
                        map.remove(num);
                    }
                }
            }

            if (map.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }
    }
}
