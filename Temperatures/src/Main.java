/*
Written by Dexter Jones
Option #2 Get Monthly Temperatures

Pseudocode:
Program that uses two arrays to store monthly temperatures (one stores months, one stores temperatures)
Program prompts user for the month to be viewed - outputs and average temp for respective month
If "year" entered, output is all months with respective temps, the yearly average, and highest & lowest monthly averages

input:
String: month/year

output:
String: month/s
float: monthly average, high average, low average

arrays: String months, float temp

user validation
 */

public class Main {
    public static String Months(int mon) {
        String result = switch (mon) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> "";
        };
        return result;
    }
    public static void main(String[] args) {
        String month;
        float temp = 0, high, low;
        String months[] = new String[12];
        float temps[] = new float[12];
        boolean isFormat = false;

        System.out.println("Monthly Average Temperature Index");

        for (int i = 0; i < 12; i++) {
            months[i] = Months(i+1);
        }
        for (int i = 0; i < 12; i++) {
            System.out.println(months[i]);
        }
    }
}