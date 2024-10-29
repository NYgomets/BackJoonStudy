import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] givenN = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            givenN[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(givenN);

        int m  = Integer.parseInt(br.readLine());
        int[] givenM = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++) {
            givenM[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<m; i++) {
            int check = Arrays.binarySearch(givenN, givenM[i]);

            if (check >= 0) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);
    }
}