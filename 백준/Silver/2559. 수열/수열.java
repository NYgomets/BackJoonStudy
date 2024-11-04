import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] day = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            day[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = k-1;
        int current = 0;

        for (int i=0; i<k; i++) {
            current += day[i];
        }

        int max = current;
        while (end<n-1) {
            current -= day[start];
            start++;

            end++;
            current += day[end];
            
            if (max < current) {
                max = current;
            }
        }

        System.out.println(max);
    }
}