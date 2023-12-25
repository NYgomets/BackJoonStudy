import java.io.*;
import java.util.*;

public class Main {
    static Scanner s = new Scanner(System.in);

    public static boolean check() {
        boolean[] check = new boolean[26];
        int prev = 0;
        String str = s.next();

        for (int i=0; i<str.length(); i++) {
            int now = str.charAt(i);

            if (prev != now) {
                if (check[now - 'a'] == false) {
                    check[now - 'a'] = true;
                    prev = now;
                }
                else {
                    return false;
                }
            }
            else {
                continue;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {

       int count = 0;
       int N = s.nextInt();

       for (int i=0; i< N; i++) {
           if (check()) {
               count++;
           }
       }

       System.out.println(count);
    }
}