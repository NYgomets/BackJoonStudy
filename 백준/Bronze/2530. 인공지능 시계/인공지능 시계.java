import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);

        int currentHour = s.nextInt();
        int currentMinute = s.nextInt();
        int currentSecond = s.nextInt();
        int timeToAdd = s.nextInt();

        int secondsToAdd = timeToAdd % 60;
        int minuteToAdd = (timeToAdd/60) % 60;
        int hoursToAdd = timeToAdd / 3600;

        currentSecond += secondsToAdd;
        if (currentSecond >=60) {
            currentSecond %= 60;
            currentMinute++;
        }

        currentMinute += minuteToAdd;
        if (currentMinute >= 60) {
            currentMinute %= 60;
            currentHour++;
        }

        currentHour = (currentHour + hoursToAdd) % 24;

        System.out.println(currentHour + " " + currentMinute + " " + currentSecond);
    }
}