import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int first = 0;
        for (int i=0; i<n; i++) {
            first += arr[i];
        }
        System.out.println(Math.round((double) first/n));
        System.out.println(arr[n/2]);
        System.out.println(check(arr));
        System.out.println(arr[n-1]-arr[0]);
    }

    private static int check(int[] arr) {
        int[] count = new int[8001];
        for (int i=0; i<arr.length; i++) {
            count[arr[i]+4000]++;
        }

        int max = 0;
        int result = 0;
        int dupCount = 0;
        for (int i=0; i< count.length; i++) {
            if (max < count[i]) {
                dupCount = 0;
                max = count[i];
                result = i-4000;
            } else if (max == count[i] && dupCount<1) {
                dupCount++;
                result = i-4000;
            }
        }

        return result;
    }
}