import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        a /= 100;
        a *= 100;

        int b = s.nextInt();

        int check = 0;
        while (true) {
            if (a%b == 0) {
                break;
            } else {
                a++;
                check++;
            }
        }

        if (check>=0 && check<=9) {
            System.out.println("0" + check);
        } else {
            System.out.println(check);
        }

    }
}