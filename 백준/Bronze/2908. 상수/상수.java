import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
       Scanner s = new Scanner(System.in);

       String first = s.next();
       String second = s.next();
       StringBuilder rf = new StringBuilder();
       StringBuilder rs = new StringBuilder();
       for (int i=first.length()-1; i>=0; i--) {
           rf.append(first.charAt(i));
       }
       for (int i=second.length()-1; i>=0; i--) {
           rs.append(second.charAt(i));
       }

        Integer a = Integer.valueOf(String.valueOf(rf));
        Integer b = Integer.valueOf(String.valueOf(rs));

        if (a>b) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }


    }
}