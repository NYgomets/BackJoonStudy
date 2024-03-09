import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s1 = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(s1.nextToken());
        int p = Integer.parseInt(s1.nextToken());
        String dnaString = String.valueOf(br.readLine());
        char[] dnaArray = dnaString.toCharArray();
        int aCheck = 0;
        int cCheck = 0;
        int gCheck = 0;
        int tCheck = 0;

        StringTokenizer s2 = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(s2.nextToken());
        int c = Integer.parseInt(s2.nextToken());
        int g = Integer.parseInt(s2.nextToken());
        int t = Integer.parseInt(s2.nextToken());
        int start_index = 0;
        int end_index = p -1;
        int count = 0;

        for (int i=start_index; i<=end_index; i++) {
            if (dnaArray[i] == 'A') {
                aCheck++;
            } else if (dnaArray[i] == 'C') {
                cCheck++;
            } else if (dnaArray[i] == 'G') {
                gCheck++;
            } else if (dnaArray[i] == 'T') {
                tCheck++;
            }
        }

        while (true) {
            if ((aCheck >= a) && (cCheck >= c) && (gCheck >= g) && (tCheck >= t)) {
                count++;
            }

            if (dnaArray[start_index] == 'A') {
                aCheck--;
            } else if (dnaArray[start_index] == 'C') {
                cCheck--;
            } else if (dnaArray[start_index] == 'G') {
                gCheck--;
            } else if (dnaArray[start_index] == 'T') {
                tCheck--;
            }

            start_index++;
            end_index++;
            if (end_index >= dnaArray.length) {
                break;
            }

            if (dnaArray[end_index] == 'A') {
                aCheck++;
            } else if (dnaArray[end_index] == 'C') {
                cCheck++;
            } else if (dnaArray[end_index] == 'G') {
                gCheck++;
            } else if (dnaArray[end_index] == 'T') {
                tCheck++;
            }

        }

        System.out.println(count);
    }
}