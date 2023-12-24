import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
       Scanner s = new Scanner(System.in);
       char[][] m = new char[5][15];

       for (int i=0; i<5; i++) {
           String l = s.next();
           for (int j=0; j<l.length(); j++) {
               m[i][j] = l.charAt(j);
           }
       }

       for (int j=0; j<15; j++) {
           for (int i=0; i<5; i++) {
               if (m[i][j] == '\0') {
                   continue;
               }
               System.out.print(m[i][j]);
           }
       }
    }
}