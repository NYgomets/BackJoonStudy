import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        boolean div = false;
        int check = n/5;
        for (int i=check; i>=0; i--) {
            int current = n-(5*i);
            int j = 0;
            while ((j*2)<=current) {
                if (current-(j*2) == 0) {
                    div = true;
                    min = Math.min(min, i+j);
                }
                j++;
            }
        }

        if (div) {
            System.out.println(min);
        } else {
            System.out.println(-1);
        }
    }
}
