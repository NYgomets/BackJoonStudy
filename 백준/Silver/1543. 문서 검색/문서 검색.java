import org.w3c.dom.Node;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    static int count = 0;
    static char[] givenRow;
    static char[] checkRow;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        givenRow = br.readLine().toCharArray();
        checkRow = br.readLine().toCharArray();

        check(0, 0);

        System.out.println(count);
    }

    private static void check(int start, int current) {
       if (start>= givenRow.length) {
           count = Math.max(count, current);
           return;
       }

       boolean check = false;
       int checkCount = 0;

       for (int i=0; i<checkRow.length; i++) {
           if (i+start >= givenRow.length) {
               break;
           }
           if (givenRow[start+i] == checkRow[i]) {
               check = true;
               checkCount++;
           } else {
               check = false;
               break;
           }
       }

       if (check && checkCount == checkRow.length) {
           current++;
           check(start+checkRow.length, current);
       } else {
           check(start+1, current);
       }

    }
}