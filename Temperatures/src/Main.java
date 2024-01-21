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
import java.util.*;
import java.text.DecimalFormat;
public class Main {
    public static String Months(int mon) { // method with months string information
        return switch (mon) {
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
    }
    public static boolean isString(String s) { // user input validation - returns true if correct choices input
        String val = s.toLowerCase();
        switch (val) {
            case "january", "february", "march", "april", "may", "june", "july", "august", "september",
                    "october", "november", "december", "year", "quit":
                val = "valid";
                break;
            default:
                val = "invalid";
        }
        return "valid".equals(val);
    }
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String month, s = "", result;
        final int SIZE = 12;
        float temp = 0, high = -100, low = 200, avg = 0, total = 0;
        String months[] = new String[SIZE];
        float temps[] = new float[SIZE];
        boolean isFormat = false, done = false;
        DecimalFormat decimalFormat = new DecimalFormat("#.##"); // formats variables to hundredths precision

        System.out.println("Monthly Average Temperature Index\n---------------------------------------");

        for (int i = 0; i < SIZE; i++) { //uses months method to insert correct string data for months array
            months[i] = Months(i+1);
        }
        for (int i = 0; i < SIZE; i++) { // insert temperature data into temps array
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
            if (temp < low) { // tracks the low temp
                low = temp;
            }
            else if (temp > high) { // tracks the high temp
                high = temp;
            }
            total += temp;
        }
        avg = total / SIZE;
        avg = Float.parseFloat(decimalFormat.format(avg));

        while (!done) { // Allows for multiple user input and choice to continue
            System.out.print("Enter the month for its average temperature.\nEnter 'year' for past year analytics.\n" +
                    "Or enter 'quit' to exit program.\n---------------------------------------\n-> : ");
            s = scnr.nextLine();

            if (isString(s)) { // checks user input to be specific month, 'year', or 'quit'
                for (int i = 0; i < SIZE; i++) { // if month is entered, output month data
                    if (months[i].equalsIgnoreCase(s)) {
                        result = months[i] + ": " + temps[i] + "\n---------------------------------------";
                        System.out.println(result);
                    }
                    else if (s.equalsIgnoreCase("year")){ // if 'year' entered, print out all months
                        result = months[i] + ": " + temps[i];
                        System.out.println(result);
                        if (i == SIZE - 1) { // Last iteration print high, low, and average data
                            result = ("---------------------------------------\n" + "Yearly High: " + high +
                                     "\nYearly Low: " + low + "\nYearly Average: " + avg
                                     + "\n---------------------------------------");
                            System.out.println(result);
                        }
                    }
                    else if (s.equalsIgnoreCase("quit")){ // exits program if 'quit' is input
                        done = true;
                    }
                }
                System.out.println("Exiting program... Goodbye!");
            }
            else { // alerts user of invalid entry
                System.out.println("Invalid entry, please try again.");
            }
        }
    }
}