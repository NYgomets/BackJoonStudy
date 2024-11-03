import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int count=1;
        int check = 666;
        while (n!=count) {
            check++;
            if (String.valueOf(check).contains("666")) {
                count++;
            }
        }
        System.out.println(check);
    }
}