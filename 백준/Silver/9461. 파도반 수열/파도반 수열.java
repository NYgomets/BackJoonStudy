import java.io.*;
import java.util.*;

public class Main {
    static long[] arr = new long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       arr[1] = 1;
       arr[2] = 1;
       arr[3] = 1;
       for (int i=4; i<=100; i++) {
           arr[i] = arr[i-3]+arr[i-2];
       }

       int t = Integer.parseInt(br.readLine());
       for (int i=0; i<t; i++) {
           int j = Integer.parseInt(br.readLine());
           System.out.println(arr[j]);
       }
    }
}
