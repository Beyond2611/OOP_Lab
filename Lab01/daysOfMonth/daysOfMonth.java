import java.time.YearMonth;
import java.util.Scanner;
public class daysOfMonth {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int month = in.nextInt();
        int year = in.nextInt();

        YearMonth curYearMonth = YearMonth.of(year, month);
        System.out.println("The number of days in " + month + "/" + year + " is " + curYearMonth.lengthOfMonth());
    }
}
