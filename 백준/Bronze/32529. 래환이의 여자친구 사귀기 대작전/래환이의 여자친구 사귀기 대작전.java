import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        int check = 0;
        st = new  StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
            int num = Integer.parseInt(st.nextToken());
            check += num;
            arr[i] = num;
        }

        if (m > check) {
            System.out.println(-1);
            return;
        }

        int sum = 0;
        for (int i=n; i>0; i--) {
            sum += arr[i];
            if (sum >= m) {
                System.out.println(i);
                return;
            }
        }
    }
}