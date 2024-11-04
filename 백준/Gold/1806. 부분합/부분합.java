import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int check = arr[0];
        int result = Integer.MAX_VALUE;
        while (end<n) {
            if (check < s) {
                end++;
                if (end<n) {
                    check += arr[end];
                }
            } else if (check >= s) {
                if (result > end-start+1) {
                    result = end-start+1;
                }
                check -= arr[start];
                start ++;
            }
        }
        
        if (result == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }
}