import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main {

    static public boolean check(int x) {
        
        if (x == 1) {
            return false;
        }
        for (int i=2; i<x; i++) {
            if (x%i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        int first = s.nextInt();
        int second = s.nextInt();
        int sum = 0;

        for (int i=first; i<=second; i++) {
            if (check(i)) {
                sum += i;
                list.add(i);
            }
        }

        int min = 0;
        
        if (list.isEmpty()) {
            System.out.println(-1);
        } else {
            min = list.get(0);
        }


        for (int i=0; i<list.size(); i++) {
            if (min > list.get(i)) {
                min = list.get(i);
            }
        }

        if (!list.isEmpty()){
            System.out.println(sum);
            System.out.println(min);
        }

    }
}