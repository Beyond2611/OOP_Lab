package Lab01.hust.soict.ict.lab01.daysOfMonth;

import java.time.YearMonth;
import java.util.Scanner;
public class daysOfMonth {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.println("Input month:");
        int month = in.nextInt();
        while(month <= 0 || month > 12){
            System.out.println("Invalid month, please input again:");
            month = in.nextInt();
        }
        System.out.println("Input year:");
        int year = in.nextInt();

        YearMonth curYearMonth = YearMonth.of(year, month);
        System.out.println("The number of days in " + month + "/" + year + " is " + curYearMonth.lengthOfMonth());
    }
}
