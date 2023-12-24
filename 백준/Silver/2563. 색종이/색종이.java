import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
       Scanner s = new Scanner(System.in);

       int count = 0;
       int n = s.nextInt();
       int[][] paper = new int[100][100];

       for (int i=0; i<n; i++) {
           int x = s.nextInt();
           int y = s.nextInt();
           for (int k=x; k<x+10; k++) {
               for (int j=y; j<y+10; j++) {
                   paper[k][j] = 1;
               }
           }
       }
       
       for (int i=0; i<100; i++) {
           for (int j=0; j<100; j++) {
               if (paper[i][j] == 1) {
                   count++;
               }
           }
       }
       
       System.out.println(count);
    }
}