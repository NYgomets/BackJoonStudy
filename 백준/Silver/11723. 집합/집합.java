import java.io.*;
import java.util.*;

public class Main {
    static Set<Integer> set = new HashSet<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String command = input[0];
            int value = (input.length > 1) ? Integer.parseInt(input[1]) : 0;

            switch (command) {
                case "add":
                    set.add(value);
                    break;
                case "remove":
                    set.remove(value);
                    break;
                case "check":
                    sb.append(set.contains(value) ? 1 : 0).append("\n");
                    break;
                case "toggle":
                    if (set.contains(value)) {
                        set.remove(value);
                    } else {
                        set.add(value);
                    }
                    break;
                case "all":
                    set.clear();
                    for (int j = 1; j <= 20; j++) {
                        set.add(j);
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }
        
        System.out.print(sb.toString());
    }
}
