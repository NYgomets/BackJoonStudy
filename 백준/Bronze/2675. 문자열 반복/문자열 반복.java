import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
       Scanner s = new Scanner(System.in);

       int test = s.nextInt();

       for (int i=0; i<test; i++) {
           int num = s.nextInt();
           String letter = s.next();

           for (int j=0; j<letter.length(); j++) {
               for (int k=0; k<num; k++) {
                   System.out.print(letter.charAt(j));
               }
           }

           System.out.println();
       }
    }
}