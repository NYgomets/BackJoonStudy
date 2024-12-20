import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        list = new int[n];
        int length = 0;
        for (int num : arr) {
            int idx = Arrays.binarySearch(list, 0, length, num);
            if (idx < 0) {
                idx = -(idx+1);
                list[idx] = num;
            }
            if (idx == length) {
                length++;
            }
        }

        System.out.println(length);
    }
}