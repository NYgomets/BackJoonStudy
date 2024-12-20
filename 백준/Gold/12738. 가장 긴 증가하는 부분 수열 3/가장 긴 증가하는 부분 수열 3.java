import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] list = new int[n];
        int length = 0;
        for (int i=0; i<n; i++) {
            int idx = Arrays.binarySearch(list, 0, length, arr[i]);
            if (idx<0) {
                list[-(idx+1)] = arr[i];
            }
            if (-(idx+1) == length) {
                length++;
            }
        }

        System.out.println(length);
    }
}