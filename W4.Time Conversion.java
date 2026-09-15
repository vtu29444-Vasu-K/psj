import java.io.*;
import java.util.*;
class Result {
    public static String timeConversion(String s) {
        int hour = Integer.parseInt(s.substring(0, 2));
        String ampm = s.substring(8, 10);
        if (ampm.equals("AM")) {
            if (hour == 12) {
                hour = 0;
            }
        } else {
            if (hour != 12) {
                hour += 12;
            }
        }
        return String.format("%02d", hour) + s.substring(2, 8);
    }
}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String result = Result.timeConversion(s);
        System.out.println(result);
        bufferedReader.close();
    }
}
