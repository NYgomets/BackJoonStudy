import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long first = Long.parseLong(st.nextToken());
        long second = Long.parseLong(st.nextToken());

        if (first == second) {
            System.out.println(0);
        } else if (first < second){
            long count = second-first-1;
            System.out.println(count);
            StringBuilder sb = new StringBuilder();
            for (long i=first+1; i<second; i++) {
                sb.append(i).append(" ");
            }
            System.out.println(sb.toString().trim());
        } else {
            long temp = first;
            first = second;
            second = temp;
            long count = second-first-1;
            System.out.println(count);
            StringBuilder sb = new StringBuilder();
            for (long i=first+1; i<second; i++) {
                sb.append(i).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}