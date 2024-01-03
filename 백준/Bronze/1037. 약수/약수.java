import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = s.nextInt();
        }

        Arrays.sort(arr);

        System.out.println(arr[0]*arr[n-1]);
    }
}