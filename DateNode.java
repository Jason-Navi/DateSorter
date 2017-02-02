
/**
 * Represents an instance of a DateNode. 
 * Has the data inside the Node which is the date and the pointer to the next Node
 */
public class DateNode
{
    /*make variables protected to limit user acsessing the variables while granting the DateList class access to the variables if needed
    Data212 data represents object of the Date212 class. DateNode next represents the pointer attached to the current Node you are in to the next Node*/
    protected Date212 data;
    protected DateNode next;

    /**Constructor for DateNode class so you can create an instance of the DateNode class and insert a new Date212 object into a Node so you can add it to your list*/
    public DateNode(Date212 d){
        data = d;
    }
}
