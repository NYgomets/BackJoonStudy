import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
       Scanner s = new Scanner(System.in);

       int n = s.nextInt();

       for (int i=1; i<=n; i++) {
           for (int j=0; j<n-i; j++) {
               System.out.print(" ");
           }
           for (int j=0; j<i; j++) {
               System.out.print("*");
           }
           for (int j=0; j<i-1; j++) {
               System.out.print("*");
           }
           System.out.println();
       }

       for (int i=1; i<n; i++) {
           for (int j=0; j<i; j++) {
               System.out.print(" ");
           }
           for (int j=0; j<n-i; j++) {
               System.out.print("*");
           }
           for (int j=0; j<n-i-1; j++) {
               System.out.print("*");
           }
           System.out.println();
       }
    }
}