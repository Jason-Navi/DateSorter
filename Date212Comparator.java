import java.util.Comparator;
/**
 * TreeMap Comparator method that is called when a new Date212 object is "put" into the Sorted Treemap 
 * list so the dates can be compared against eachother
 */
public class Date212Comparator implements Comparator <Date212>
{
    /**Gives the TreeMap a method to be able to compare the Date212 objects and thus, sort it properly*/
    public int compare(Date212 date1, Date212 date2){
        //returns a negative number if date1 comes before date2 otherwise returns a positive number 
        return date1.toString().compareTo(date2.toString());
    }
}
