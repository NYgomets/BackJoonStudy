import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
       Scanner s = new Scanner(System.in);

       int[][] a = new int[9][9];
       int max = 0;
       int n = 0;
       int m = 0;

       for (int i=0; i<9; i++) {
           for (int j=0; j<9; j++) {
               a[i][j] = s.nextInt();
           }
       }

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if(a[i][j] >= max) {
                    max = a[i][j];
                    n = i+1;
                    m = j+1;
                }
            }
        }

        System.out.println(max);
        System.out.print(n + " " + m);
    }
}