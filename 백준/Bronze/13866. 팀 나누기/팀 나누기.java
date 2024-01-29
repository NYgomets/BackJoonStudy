import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[4];
        for(int i=0;i<4;i++){
            arr[i]=scanner.nextInt();
        }
        Arrays.sort(arr);
        System.out.println(Math.abs((arr[0]+arr[3])-(arr[1]+arr[2])));
    }
}