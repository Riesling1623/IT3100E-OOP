package hust.soict.dsai.lab01;
// Exercise 6.4
import java.util.*;

public class DayOfMonth {
    // Check leap year
    public static boolean checkLeap (int year){
        if (year % 400 == 0){
            return true;
        }
        else if (year % 100 == 0){
            return false;
        }
        else if (year % 4 == 0){
            return true;
        }
        return false;
    }

    public static int numberOfDays(String month, int year){
        // Month which have 31 days
        if (month.equals("January") || month.equals("Jan") || month.equals("Jan.") || month.equals("1") ||
            month.equals("March") || month.equals("Mar") || month.equals("Mar.") || month.equals("3") || month.equals("May") || 
            month.equals("5") || month.equals("July") || month.equals("Jul") || month.equals("7") || month.equals("August") || 
            month.equals("Aug") || month.equals("Aug.") || month.equals("8") || month.equals("October") || month.equals("Oct") || 
            month.equals("Oct.") || month.equals("10") || month.equals("December") || month.equals("Dec") || month.equals("Dec.") || 
            month.equals("12")){
                return 31;
        }
        
        // Month which have 30 days
        else if (month.equals("April") || month.equals("Apr") || month.equals("Apr.") || month.equals("4") || 
        month.equals("June") || month.equals("Jun") || month.equals("6") || month.equals("September") || month.equals("Sep") || 
        month.equals("Sept.") || month.equals("9") || month.equals("November") || month.equals("Nov") || month.equals("Nov.") || 
        month.equals("11")){
            return 30;
        }

        // Month is February
        if (checkLeap(year) == true){
            return 29;
        }
        else {
            return 28;
        }
    }

    public static void main(String[] args){
        // All formats of month
        String[] MONTH_FORMAT_ARR = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December", 
        "Jan", "Feb", "Mar", "Apr", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", 
        "Jan.", "Feb.", "Mar.", "Apr.", "Aug.", "Sept.", "Oct.", "Nov.", "Dec.", 
        "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        // Change array to array list
        List<String> MONTH_FORMAT_LIST = Arrays.asList(MONTH_FORMAT_ARR);

        Scanner scan = new Scanner(System.in);
        
        // Input month
        System.out.print("Enter month: ");
        String month = scan.next();
        boolean retval = MONTH_FORMAT_LIST.contains(month);
        while (retval == false){
            System.out.print("Invalid month. Enter month again: ");
            month = scan.next();
            retval = MONTH_FORMAT_LIST.contains(month);
        }

        // Input year
        System.out.print("Enter year: ");
        int year = scan.nextInt();
        while (year < 0){
            System.out.print("Invalid year. Enter year again: ");
            year = scan.nextInt();
        }
        scan.close();

        System.out.println("The number of days: " + numberOfDays(month, year));
    }
}
