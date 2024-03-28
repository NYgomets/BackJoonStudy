import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int num = Integer.parseInt(br.readLine());
       int resultNum = 1000 - num;
       int count = 0;

       while (resultNum>0) {
           int i500 = resultNum / 500;
           count += i500;
           resultNum -= (500*i500);
           if (resultNum == 0) {
               break;
           }

           int i100 = resultNum / 100;
           count += i100;
           resultNum -= (100*i100);
           if (resultNum == 0) {
               break;
           }

           int i50 = resultNum / 50;
           count += i50;
           resultNum -= (50*i50);
           if (resultNum == 0) {
               break;
           }

           int i10 = resultNum / 10;
           count += i10;
           resultNum -= (10*i10);
           if (resultNum == 0) {
               break;
           }

           int i5 = resultNum / 5;
           count += i5;
           resultNum -= (5*i5);
           if (resultNum == 0) {
               break;
           }

           int i1 = resultNum;
           count += i1;
           resultNum -= (i1);
           break;
       }

        System.out.println(count);
    }
}