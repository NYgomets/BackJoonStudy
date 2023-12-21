import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
       Scanner s = new Scanner(System.in);

       int n = s.nextInt();
       String a = s.next();

       int sum=0;

       for (int i=0; i<n; i++) {
           sum += a.charAt(i) - '0';
       }

       System.out.println(sum);
    }
}