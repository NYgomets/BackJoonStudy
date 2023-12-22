import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
       Scanner s = new Scanner(System.in);
       double sum = 0;
       double alltime = 0;

       for (int i=0; i<20; i++) {
           String subject = s.next();
           double time = s.nextDouble();
           String grade = s.next();

           switch (grade) {
               case "A+": sum += (time * 4.5); alltime += time; break;
               case "A0": sum += (time * 4.0); alltime += time; break;
               case "B+": sum += (time * 3.5); alltime += time; break;
               case "B0": sum += (time * 3.0); alltime += time; break;
               case "C+": sum += (time * 2.5); alltime += time; break;
               case "C0": sum += (time * 2.0); alltime += time; break;
               case "D+": sum += (time * 1.5); alltime += time; break;
               case "D0": sum += (time); alltime += time; break;
               case "F": sum += (time * 0.0); alltime += time; break;
               case "P": break;
           }
       }

       System.out.println(sum/alltime);
    }
}