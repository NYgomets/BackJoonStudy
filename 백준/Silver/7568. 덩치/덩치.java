import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new LinkedList<>();

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new int[]{x, y});
        }

        for (int j=0; j<N; j++) {
            int rank = 1;
            int[] first = list.get(j);
            for (int k=0; k<N; k++) {
                int[] second = list.get(k);

                if ((first[0] < second[0]) && (first[1] < second[1])) {
                    rank++;
                }
            }
            System.out.print(rank + " ");
        }
    }
}