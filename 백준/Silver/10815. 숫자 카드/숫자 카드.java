import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int putNum = Integer.parseInt(st.nextToken());
            map.put(putNum, 1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int j=0; j<M; j++) {
            int checkNum = Integer.parseInt(st.nextToken());
            if (j<M-1) {
                System.out.print(map.getOrDefault(checkNum, 0) + " ");
            } else {
                System.out.print(map.getOrDefault(checkNum, 0));
            }
        }
    }
}