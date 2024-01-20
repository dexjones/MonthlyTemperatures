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
import java.util.Random;
import java.text.DecimalFormat;
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
        final int SIZE = 12;
        float temp = 0, high, low;
        String months[] = new String[SIZE];
        float temps[] = new float[SIZE];
        boolean isFormat = false;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        System.out.println("Monthly Average Temperature Index");

        for (int i = 0; i < SIZE; i++) {
            months[i] = Months(i+1);
        }
        for (int i = 0; i < SIZE; i++) {
            if (i <= 1 || i == 11) { // Winter months Dec-Feb
                temp = new Random().nextFloat(60) - 15; // random temp from -15 to 45 degrees
            }
            else if ( i >= 2 && i <= 4) { // Spring months
                temp = new Random().nextFloat(80); // random temp from 0-80
            }
            else if (i >= 5 && i <= 7) { // Summer months
                temp = new Random().nextFloat(45) + 60; // random temp from 60-105
            }
            else { // Fall months
                temp = new Random().nextFloat(45) + 20; // random temp from 20-65
            }
            temp = Float.parseFloat(decimalFormat.format(temp));
            temps[i] = temp;
        }
        for (int i = 0; i < 12; i++) {
            System.out.println(months[i] + ": " + temps[i]);
        }
    }
}