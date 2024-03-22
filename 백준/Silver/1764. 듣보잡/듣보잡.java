import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new TreeMap<>();
        int count = 0;

        for (int i=0; i<N+M; i++) {
            String check = br.readLine();
            if (i<N) {
                set.add(check);
            } else {
                if (set.contains(check)) {
                    map.put(check, 1);
                    count++;
                }
            }
        }

        System.out.println(count);
        for (String str:map.keySet()) {
            System.out.println(str);
        }
    }
}