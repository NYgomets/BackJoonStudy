import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        char[] dna = (br.readLine()).toCharArray();
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int checkA = 0;
        int c = Integer.parseInt(st.nextToken());
        int checkC = 0;
        int g = Integer.parseInt(st.nextToken());
        int checkG = 0;
        int t = Integer.parseInt(st.nextToken());
        int checkT = 0;
        int start = 0;
        int end = p-1;
        int count = 0;
        for (int i=start; i<=end; i++) {
            if ('A' == dna[i]) {
                checkA++;
            } else if ('C' == dna[i]) {
                checkC++;
            } else if ('G' == dna[i]) {
                checkG++;
            } else if ('T' == dna[i]){
                checkT++;
            }
        }

        if ((a<=checkA) && (c<=checkC) && (g<=checkG) && (t<=checkT)) {
            count++;
        }

        while (end < s-1) {

            if (dna[start] == 'A') {
                checkA--;
            } else if (dna[start] == 'C') {
                checkC--;
            } else if (dna[start] == 'G') {
                checkG--;
            } else if (dna[start] == 'T') {
                checkT--;
            }
            start++;

            end++;
            if (dna[end] == 'A') {
                checkA++;
            } else if (dna[end] == 'C') {
                checkC++;
            } else if (dna[end] == 'G') {
                checkG++;
            } else if (dna[end] == 'T') {
                checkT++;
            }
            if ((a<=checkA) && (c<=checkC) && (g<=checkG) && (t<=checkT)) {
                count++;
            }
        }
        System.out.println(count);
    }
}