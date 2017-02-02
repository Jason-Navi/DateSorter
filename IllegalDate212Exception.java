
/**
 * extends IllegalArgument Exception to create an IllegalDate212 Exception that is thrown whenever
 * the date is not valid
 */
public class IllegalDate212Exception extends IllegalArgumentException
{
    /**Constructor Uses the super() function to call constructor of IllegalArgumentException and
     * throw the same message but except as a IllegalDate212Exception
     */ 
    public IllegalDate212Exception(String msg) {
        super(msg);
    }
}
