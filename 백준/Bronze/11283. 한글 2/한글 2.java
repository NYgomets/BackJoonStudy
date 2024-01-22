import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        
        char hangul = s.nextLine().charAt(0);
        System.out.println((int) hangul - 44031);
    }
}