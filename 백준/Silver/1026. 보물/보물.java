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
        Integer[] Aarr = new Integer[N];
        Integer[] Barr = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            Aarr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int j=0; j<N; j++) {
            Barr[j] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(Aarr);
        Arrays.sort(Barr, Collections.reverseOrder());

        int S = 0;
        for (int k=0; k<N; k++) {
            S += (Aarr[k] * Barr[k]);
        }

        System.out.println(S);
    }
}