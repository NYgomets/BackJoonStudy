import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        s.nextLine();
        String[] name = new String[n];

        for (int i=0; i<n; i++) {
            name[i] = s.next().toLowerCase();
        }

        for (String letter:name) {
            System.out.println(letter);
        }
    }
}