import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int[] check = new int[8];

        for (int i=0; i<8; i++) {
            int num = s.nextInt();
            check[i] = num;
        }

        String letter = "";

        for (int i=0; i<7; i++) {
            if (check[i] == check[i+1] - 1) {
                letter = "ascending";
            } else if (check[i] == check[i+1] + 1) {
                letter = "descending";
            } else {
                letter = "mixed";
                break;
            }
        }

        System.out.println(letter);
    }
}