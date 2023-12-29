import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        int x = s.nextInt();
        int y = s.nextInt();
        int w = s.nextInt();
        int h = s.nextInt();

        int lx = x;
        list.add(lx);
        int rx = w-x;
        list.add(rx);
        int uy = y;
        list.add(uy);
        int hy = h-y;
        list.add(hy);

        Collections.sort(list);

        System.out.println(list.get(0));

    }
}