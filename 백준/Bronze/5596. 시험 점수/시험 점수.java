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

        int[] min = new int[4];
        int[] man = new int[4];
        
        for (int i=0; i<4; i++) {
            min[i] = s.nextInt();
        }
        for (int i=0; i<4; i++) {
            man[i] = s.nextInt();
        }
        
        int minSum = 0;
        int manSum = 0;
        
        for (int i=0; i<4; i++) {
            minSum += min[i];
            manSum += man[i];
        }
        
        if (minSum>=manSum) {
            System.out.println(minSum);
        } else {
            System.out.println(manSum);
        }
    }
}