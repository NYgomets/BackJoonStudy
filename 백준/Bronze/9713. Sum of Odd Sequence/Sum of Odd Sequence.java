import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++) {
            int num = Integer.parseInt(br.readLine());
            int sum = 0;
            for (int j=1; j<=num; j+=2) {
                sum += j;
            }
            System.out.println(sum);
        }
    }
}
