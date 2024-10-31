import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++) {
            String string = br.readLine();
            String[] split = string.split(",");
            System.out.println(Integer.parseInt(split[0])+Integer.parseInt(split[1]));

        }

    }
}