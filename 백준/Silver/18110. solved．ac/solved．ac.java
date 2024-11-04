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
        int minusPerson = Integer.parseInt(String.valueOf(Math.round(n*0.15)));
        double result = 0;
        for (int i=minusPerson; i<n-minusPerson; i++) {
            result += arr[i];
        }
        System.out.println(Math.round(result/(n-(2*minusPerson))));
    }
}