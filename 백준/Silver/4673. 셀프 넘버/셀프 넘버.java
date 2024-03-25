import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean[] check =  new boolean[30000];
        Arrays.fill(check, true);

        check[0] = false;
        for (int i=1; i<check.length; i++) {
            if (i<10) {
                check[i+i] = false;
            } else if (i<100) {
                check[i+(i/10)+(i%10)] = false;
            } else if (i<1000) {
                check[i+(i/100)+((i%100)/10)+(i%10)] = false;
            } else if (i<10000) {
                check[i+(i/1000)+((i%1000)/100)+((i%100)/10)+(i%10)] = false;
            } else {
                check[i] = false;
            }
        }

        for (int i=1; i<=10000; i++) {
            if (check[i]) {
                System.out.println(i);
            }
        }
    }
}