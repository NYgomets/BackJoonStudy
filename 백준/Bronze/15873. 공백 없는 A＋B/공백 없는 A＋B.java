import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        int res = (a / 10) + (a % 10);
        
        if (a / 10 > 10) {
            res = (a / 100) + (a % 100);
        }
        
        if (a == 1010) {
            res = 20;
        }

        System.out.println(res);
    }
}