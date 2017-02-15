# TreeMapDateSorter
Author: Jason Navi

Email: jnavi1002@gmail.com

Program Description: Program obtains input from a textfile (.txt) and sorts the data based on date.
Then it prints on the left side of the GUI the unsorted dates and the right side of the GUI the sorted dates.
Also prints out any invalid dates (dates literally not possible) entered as a Date212 Exception as well as any incorrect forms of Strings. This project was created to sort dates by using both a Linked-List created from scratch and a TreeMap to sort. 
Prints dates out in mm/dd/yyyy order.

IDE used: BlueJ

Libraries used: Java.util, javax.swing, java.awt, java.awt.event, java.io, java.io.BufferedReader, java.io.FileInputStreamReader, java.ioInputStreamReader, java.IOException, java.util.Comparator

Classes used: DateNode, DateGUI, FileMenuHandler, TextFileInput, IllegalDate212Exception, UnsortedDateList, Date212, Date212Comparator, dateRunner, and DateList(abstract)

How to run: For instance, typing in the textfile named "inputs": 1998/02/6, 1994/11/13, 1998/01/10 will display the following on different lines. Note: You can type any series of dates in the textfile in yyyy/mm/dd order and it will run properly. 

Left-hand side of GUI: 02/6/1998, 11/13/1994, 01/10/1998  

Right-hand side of GUI: 11/13/1994, 01/10/1998, 02/06/1998       
                                                   
                                                     
