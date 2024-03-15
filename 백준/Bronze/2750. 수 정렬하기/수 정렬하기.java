import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] checkArray = new int[N];

        for (int i=0; i<N; i++) {
            checkArray[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(checkArray);

        for (int i=0; i<N; i++) {
            System.out.println(checkArray[i]);
        }
    }
}