import java.util.*;
/**
 * Class that represents the date object with the day, month and year. Makes sure that there are no invalid dates and has a 3 parameter constructor of integers 
 * as well as a 1 parameter constructor of a string that parses and passes to the 3 arg constructor. Has a toString() method that returns the date for sorting 
 */
public class Date212
{
    //create three instance variables to represent the year, month and date
    private int year;
    private int month;
    private int day;

    /**create a 3 parameter constructor that takes in the month, date and year and assigns each value to its respective variable. 
    if the month or day or year is less than 1 throw an expection. If the day is greater than 31 or the month is bigger than 12 than throw an exception as well*/
    public Date212(int y, int m, int d){
        if(m < 1 || m > 12 || y < 1 || d < 1 || d > 31 || y > 2016) 
            throw new IllegalDate212Exception("Invalid date");
        year = y;
        month = m;
        day = d;
    }

    /**parameter string constructor that u can use the "this" operator to call the 3 parameter constructor and taking the specific indeces that pertain to each respective variable, 
    parsing it to an integer so it properly calls the 3 parameter constructor.*/
    public Date212(String date){
        this(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(4, 6)), Integer.parseInt(date.substring(6)));
    }

    /**Method that sends back the date in the proper order to compare it to other dates and thus allow for sorting*/
    public String toString(){
        //Declare and initialize a date a var and add the year to it.
        String date = "" + year;
        //if the month is less than ten add a zero and then append it to the date string to preserve the string length of 8. Otherwise just add the month if its more than 10
        if(month < 10) 
            date += "0" + month;
        else date += month;
        //if the day is less than ten add a zero and then append it to the date string to preserve the string length of 8. Otherwise just add the day if its more than 10
        if(day < 10) 
            date += "0" + day;
        else date += day;
        //return the date
        return date;
    }

    /**method that prints the dates inside the TreeMap in mm/dd/yyyy order*/
    public String printSortedTree(){
        //declare and initialize a date variable to an empty string
        String date = "";

        //if the month is less than ten add a zero and then append it to the date string with a forward slash. Otherwise just add the month if its more than 10 with a forward slash
        if(month < 10)
            date += "0" + month + "/"; 
        else date += month + "/";

        //if the day is less than ten add a zero and then append it to the date string with a forward slash. Otherwise just add the month if its more than 10 with a forward slash
        if(day < 10)
            date += "0" + day + "/";
        else date += day + "/";

        //append the year to the end of the date string and return it so it can be printed to the GUI
        return date + year;
    }
}
