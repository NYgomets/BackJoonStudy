import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        System.out.println((int)Math.pow(Math.pow(2, N) +1, 2));
    }
}