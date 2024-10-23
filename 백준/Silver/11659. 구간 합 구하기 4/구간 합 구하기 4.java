import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String givenNum = br.readLine();
        StringTokenizer st = new StringTokenizer(givenNum);
        int N = Integer.parseInt(String.valueOf(st.nextToken()));
        int M = Integer.parseInt(String.valueOf(st.nextToken()));

        int[] arr = new int[N+1];
        int[] sum = new int[N+1];
        String number = br.readLine();
        st = new StringTokenizer(number);
        arr[1] = Integer.parseInt(String.valueOf(st.nextToken()));
        sum[1] = arr[1];
        for (int i=2; st.hasMoreTokens(); i++) {
            arr[i] = Integer.parseInt(String.valueOf(st.nextToken()));
            sum[i] = sum[i-1] + arr[i];
        }

        for (int j=0; j<M; j++) {
            String value = br.readLine();
            st = new StringTokenizer(value);
            int a = Integer.parseInt(String.valueOf(st.nextToken()));
            int b = Integer.parseInt(String.valueOf(st.nextToken()));
            System.out.println(sum[b] - sum[a-1]);
        }
    }
}