import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int num = s.nextInt();
        int count = num;

        for (int i=0; i<num; i++) {
            int n = s.nextInt();
            if (n==1) {
                count--;
            }
            for (int j=2; j<n; j++) {
                if (n%j == 0) {
                    count--;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}