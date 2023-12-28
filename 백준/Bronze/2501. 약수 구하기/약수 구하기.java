import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();

        int num = Integer.parseInt(st.nextToken());
        int turn = Integer.parseInt(st.nextToken());

        for (int i=1; i<=num; i++) {
            if (num%i == 0) {
                list.add(i);
            }
        }

        if (list.isEmpty() || turn <=0 || turn>list.size()) {
            System.out.println(0);
        } else {
            int hit = list.get(turn-1);
            System.out.println(hit);
        }
    }
}