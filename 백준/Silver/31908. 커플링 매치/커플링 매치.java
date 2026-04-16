import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Map<String, List<String>> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++) {
            st = new  StringTokenizer(br.readLine());
            String name = st.nextToken();
            String ring = st.nextToken();
            if (ring.equals("-")) {
                continue;
            }

            map.putIfAbsent(ring, new ArrayList<>());
            map.get(ring).add(name);
        }

        int couple = 0;
        List<String> list = new ArrayList<>();
        for (String s : map.keySet()) {
            if (map.get(s).size() == 2) {
                couple++;
                list.add(map.get(s).get(0) + " " + map.get(s).get(1));
            }
        }

        System.out.println(couple);
        for (String s : list) {
            System.out.println(s);
        }
    }
}