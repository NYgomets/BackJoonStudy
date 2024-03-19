import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();

        for (int k=0; k<N; k++) {
            int i = Integer.parseInt(st.nextToken());
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int q=0; q<M; q++) {
            if (q<M-1) {
                int i = Integer.parseInt(st.nextToken());
                sb.append(map.getOrDefault(i, 0)).append(" ");
            } else if (q == M-1) {
                int i = Integer.parseInt(st.nextToken());
                sb.append(map.getOrDefault(i, 0));
            }
        }

        System.out.print(sb);
    }
}