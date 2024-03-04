import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int M = s.nextInt();

        int[] nArray = new int[N+1];

        for (int i=1; i<=N; i++) {
            nArray[i] = s.nextInt();
        }

        long[] sumArray = new long[N+1];
        sumArray[1] = nArray[1];

        for (int i=2; i<nArray.length; i++) {
            sumArray[i] = sumArray[i-1] + nArray[i];
        }

        for (int k=0; k<M; k++) {
            int i = s.nextInt();
            int j = s.nextInt();

            long check = sumArray[j] - sumArray[i-1];

            System.out.println(check);
        }
    }
}