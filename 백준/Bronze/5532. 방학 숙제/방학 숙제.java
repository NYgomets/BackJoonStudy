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

        int day = s.nextInt();
        int homeworkKorean = s.nextInt();
        int homeworkMath = s.nextInt();
        int doKorean = s.nextInt();
        int doMath = s.nextInt();

        double max = 0;
        max = Math.max((double)homeworkKorean/doKorean, (double)homeworkMath/doMath);
        max = Math.ceil(max);
        day -= (int)max;
        System.out.println(day);
    }
}