import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
       Scanner s = new Scanner(System.in);

       int n = 0;
       String letter = s.nextLine();
       String input = letter.trim();

      if (!input.isEmpty()) {
          n++;
          
          for (int i=0; i<input.length(); i++) {
              if (input.charAt(i) == ' ') {
                  n++;
              }
          }
      }


       System.out.println(n);
    }
}