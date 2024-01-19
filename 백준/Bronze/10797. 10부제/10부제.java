import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        
        int car = s.nextInt();
        int count = 0;
        for (int i=0; i<5; i++) {
            if (car == s.nextInt()) {
                count++;
            }
        }
        System.out.println(count);
    }
}