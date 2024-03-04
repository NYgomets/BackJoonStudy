import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int Num = s.nextInt();
        String sNum = s.next();
        char[] charArray = sNum.toCharArray();

        int sum = 0;

        for (int i=0; i<charArray.length; i++) {
            int check = charArray[i] - 48;
            sum += check;
        }

        System.out.println(sum);
    }
}