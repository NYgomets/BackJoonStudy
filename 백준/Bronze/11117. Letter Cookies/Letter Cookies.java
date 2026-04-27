import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            String alpaList = sc.next();
            int w = sc.nextInt();
            Map<Character, Integer> alpaMap = new HashMap<>();
            for (char c : alpaList.toCharArray()) {
                alpaMap.put(c, alpaMap.getOrDefault(c, 0) + 1);
            }
            
            for (int j = 0; j < w; j++) {
                String line = sc.next();
                Map<Character, Integer> tempMap = new HashMap<>(alpaMap);
                boolean flag = true;

                for (char c : line.toCharArray()) {
                    if (tempMap.containsKey(c) && tempMap.get(c) > 0) {
                        tempMap.put(c, tempMap.get(c) - 1);
                    } else {
                        flag = false;
                        break;
                    }
                }

                System.out.println(flag ? "YES" : "NO");
            }
        }
    }
}