import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        int providedNum = Integer.parseInt(br.readLine());

        int start_index = 0;
        int end_index = n-1;
        int checkNum = a[start_index] + a[end_index];
        int count = 0;

        while (start_index<end_index) {
            if (checkNum < providedNum) {
                checkNum -= a[start_index];
                start_index++;
                checkNum += a[start_index];
            } else if (checkNum == providedNum) {
                count++;
                checkNum -= a[end_index];
                end_index--;
                checkNum += a[end_index];
            } else {
                checkNum -= a[end_index];
                end_index--;
                checkNum += a[end_index];
            }
        }

        System.out.println(count);
    }
}