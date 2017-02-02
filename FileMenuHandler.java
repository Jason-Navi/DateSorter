import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
/**
 * Program contains a constructor that contains a parameter that will intialize a DateGUi object. Also contains an
 * actionPerformed method that if the user clicks on open a file directory will open allowing the user to choose any 
 * text file or will print a message that says you clicked on quit if the user decides to
 * Try-catch block added to catch any Date212IllegalExcpetions 
 * 
 * Program obtains input from textfile and puts inside the unsortedDateList Date212 objects in the order they were read (unsorted) 
 * and inside the TreeMap it puts the Date212 objects in the order they were read (unsorted) however, when you call the "put" method on treemap 
 * to put a Date212 object inside it has a compare method it utilizes in the Date212Comparator class that allows it to sort the date as it puts Date212 objects inside it
 * 
 * Jason Navi
 * Lab section 11C (42704)
 */
public class FileMenuHandler implements ActionListener {
    //declare a DateGUI object
    DateGUI jframe;

    //declare and initialize a DateList of unsorted and a TreeMap of sorted values. TreeMap will be using the Date212Comparator class to sort its Date212 objects
    UnsortedDateList unsorted = new UnsortedDateList();
    TreeMap <Date212, Date212> sorted = new TreeMap(new Date212Comparator());

    /**initialize the DateGUI object to the DateGUI parameter given*/
    public FileMenuHandler (DateGUI jf){
        jframe = jf;
    }

    /**reads file if user clicks "open" otherwise it quits and prints a message that you are quitting*/
    public void actionPerformed(ActionEvent event){
        //gets the string from the ActionEvent "event" object by calling .getActionCommand()
        String menuName = event.getActionCommand();

        //if the user click opened then read the file and create a Jframe and print the dates in sorted and unsorted order
        if (menuName.equals("Open")){
            //Create a JFileChooser object that you will allow the user to pick out the text file they want to read from
            JFileChooser fd = new JFileChooser();

            //Only allows the user to see and pick files displayed in the folders
            fd.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fd.showOpenDialog(null);

            //Create a File object based on the one the user picked
            File f = fd.getSelectedFile();

            //Create a TextFileInput object of the file the user picked on and goes into that directory/folder destination to find the file
            TextFileInput myFile = new TextFileInput(f.getAbsolutePath());

            //create object of TextFileInput class to read the file line by line. 
            //creates a string array of size loop to store the dates
            //create count variable to increment through the dates array
            //initialize line String so you can begin looping without a null pointer reference error 
            String[] d = new String[1000];
            int count = 0;
            String line = " ";

            //loop while the line you are reading isin't null
            while(line != null){   
                //read the first line of the text file and store it in line. If it is null break out of the loop and end it. This prevents you from accsessing a null value when initializing the StringTokenizer object myTokens
                line = myFile.readLine();
                if(line == null) 
                    break;
                //Create a StringTokenizer object to read the line and seperate out the commas from the date values.
                StringTokenizer myTokens = new StringTokenizer(line, ",");

                //loop while there are still dates in the myTokens object
                while(myTokens.countTokens() != 0){
                    //store the next token date inside the dates array at position count
                    d[count] = myTokens.nextToken();

                    //if the date inside the array at index count is not a valid date then make the index at count equal to null and go deincrement count by 1 so you don't have a gap between valid dates.
                    //Otherwise just increment the counter by 1 if it is valid and continue on
                    if(!verify(d[count])){
                        d[count] = null;
                        count--;
                    }
                    count++;
                }
            }
            /*insert the dates by traversing through the index of dates and using the "new" keyword to instantiate a new Date212 object at the specified index
            The sorted list is using the put method of the TreeMap to keep the dates sorted while the unsorted dates are using the append method of the UnsortedDateList class which will just add on the date to the end of the list
            loop through the list of dates until there are none left (start at index 0) and then once the loop is complete initialize the jframe with the unsorted and sorted dates respectively (UnsortedDateList and TreeMap)
            put the whole thing in a try catch block to catch any IllegalDate212Exceptions and print them out if found*/
            for(int i = 0; d[i] != null; i++){
                try{
                    sorted.put(new Date212(d[i]), new Date212(d[i]));
                    unsorted.add(new Date212(d[i]));   
                }catch(IllegalDate212Exception a){
                    System.out.println(a);
                }
            }
            //initialize the DateGUI object with the unsorted and sorted list of dates
            jframe.initialize(unsorted, sorted);
        }

        //otherwise the user clicked "Quit" and print a JOptionPane message stating that they quit and exit the program
        else if(menuName.equals("Quit")){
            JOptionPane.showMessageDialog(null,"You clicked on Quit"); 
            System.exit(0);
        }
    } 

    /**Verifies that the date is valid. If it is, it returns true otherwise it prints out the invalid date and returns false*/
    public static boolean verify(String str){
        //if the string is not of length eight then print it out and return false because it is not a valid date.
        if(str.length() != 8){ 
            System.out.println(str);
            return false;
        }

        //If any of the chars in the string is a letter then print it out and return false because it is not a valid date 
        for(int i = 0; i < 8; i++){
            if(!Character.isDigit(str.charAt(i))){
                System.out.println(str);
                return false;
            }
        }
        //otherwise the date must be true so return true
        return true;
    }
}