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

        int[] burger = new int[3];
        int[] drink = new int[2];

        for (int i=0; i<burger.length; i++) {
            burger[i] = s.nextInt();
        }
        for (int i=0; i< drink.length; i++) {
            drink[i] = s.nextInt();
        }
        Arrays.sort(burger);
        Arrays.sort(drink);

        System.out.println(burger[0] + drink[0] - 50);
    }
}