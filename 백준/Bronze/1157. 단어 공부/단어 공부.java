import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       Scanner s = new Scanner(System.in);

       String letter = s.next();
       String lowerCase = letter.toUpperCase();

       int[] arr = new int[26];

       Arrays.fill(arr, 0);

       int max = 0;
       String r = null;

       for (int i=0; i<lowerCase.length(); i++) {
           char c = lowerCase.charAt(i);
           arr[c - 'A']++;
       }

       for (int i=0; i<arr.length; i++) {
           if (arr[i] > max) {
               max = arr[i];
               r = String.valueOf((char) (i + 65));
           } else if (arr[i] == max) {
               r = "?";
           }
       }
       
       System.out.println(r);
    }
}