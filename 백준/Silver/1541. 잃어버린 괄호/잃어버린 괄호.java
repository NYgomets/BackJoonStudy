import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String givenRow = br.readLine();
        String[] firstSplit = givenRow.split("-");
        int result = 0;
        int check;
        for (int i=0; i< firstSplit.length; i++) {
            check = 0;
            String[] split = firstSplit[i].split("\\+");
            for (int j=0; j<split.length; j++) {
                check += Integer.parseInt(split[j]);
            }

            if (i==0) {
                result = check;
            } else {
                result -= check;
            }
        }

        System.out.println(result);
    }
}