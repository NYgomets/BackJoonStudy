import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
       Scanner s = new Scanner(System.in);

       String letter = s.next();
       StringBuilder output = new StringBuilder();

       for (int i=letter.length()-1; i>=0; i--) {
           output.append(letter.charAt(i));
       }

       if (letter.equals(String.valueOf(output))) {
           System.out.println(1);
       } else {
           System.out.println(0);
       }
    }
}