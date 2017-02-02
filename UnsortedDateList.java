
/**
 * Respresents a list of unsorted date note object and extends DateList
 * List of unsorted dates in the order they were read from the file.
 */
public class UnsortedDateList extends DateList
{
    //first node in the linked list which is a dummy node
    private DateNode first;

    //last node in the linked list
    private DateNode last;

    //number of data items in the linked list
    private int length;

    /**No arg constructor for DateList first and last are set to default DateNode (null) and length is set to 0*/
    public UnsortedDateList(){
        first = new DateNode(null);
        last = first;
        length = 0;
    }

    /**Adds a Node to the end of the Linked List*/
    public void add(Date212 d){
        //Create a new DateNode using the Date212 object given in the parameter 
        DateNode n = new DateNode(d);
        //make the pointer of the last Node point to the new DateNode just created
        last.next = n;
        //Make the "last" var which is the last Node now equal to the new DateNode just created
        last = n;
        //increment the length by one since you just added a new Node to the list
        length++;
    }

    /**return all the dates inside the linked list*/
    public String getList(){
        //create a String "allDates" that will concatenate all the dates
        String allDates = "";

        //Create a new DateNode and increment it one from the first Node so you are not looking at the dummy node
        DateNode p = first.next;

        //Loop through the var "p" which represents a DateNode until you have gone through all Node's in the List
        while (p != null){
            //Add the data inside node "p" which represents the date to allDates and increment to the next Node
            allDates += p.data;
            p = p.next;
        }

        //return the String with all the dates inside
        return allDates;
    } 
}
