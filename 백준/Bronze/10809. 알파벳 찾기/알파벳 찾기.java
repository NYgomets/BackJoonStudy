import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
       Scanner s = new Scanner(System.in);

       String a = s.next();

       int[] arr = new int[26];
        Arrays.fill(arr, -1);

       for(int i=0; i<a.length(); i++) {
           char c = a.charAt(i);

           if (arr[c-'a'] == -1) {
               arr[c-'a'] = i;
           }
       }

        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
}